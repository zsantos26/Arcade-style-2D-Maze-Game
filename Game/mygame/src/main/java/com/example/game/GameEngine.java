package com.example.game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.example.abstractfactory.GameObjectFactory;
import com.example.characters.BonusRewards;
import com.example.characters.MainCharacter;
import com.example.characters.MovingEnemy;
import com.example.characters.StaticEnemy;
import com.example.characters.StaticRewards;
import com.example.menu.PlayScreen;

import java.util.ArrayList;
import java.util.Random;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GameEngine extends JPanel implements Runnable {
  // Set the Screen Size
  final int originalCellSize = 16; // 20x20 Cells
  final int scale = 3;
  // Screen Dimensions
  public final int cellSize = originalCellSize * scale;
  public final int maxScreenCol = 20;
  public final int maxScreenRow = 20;
  public final int screenWidth = cellSize * maxScreenCol;
  public final int screenHeight = cellSize * maxScreenRow;

  public final int maxMap = 3;
  public int currentMap = 0;
  public int gameState;

  private ArrayList<StaticEnemy> staticEnemies = new ArrayList<StaticEnemy>();
  private ArrayList<MovingEnemy> movingEnemies = new ArrayList<MovingEnemy>();
  private ArrayList<StaticRewards> staticRewardsList = new ArrayList<StaticRewards>();
  private BonusRewards bonusReward;

  // Abstract Factory
  private GameObjectFactory gameObjectFactory;
  public MainCharacter mainChar;
  public BonusRewards bonusRewards;
  public StaticRewards staticRewards;
  public MovingEnemy movingEnemy;
  public StaticEnemy staticEnemy;
  // Keyboard Input
  GameInput keyBoard = new GameInput();
  Thread gameThread;
  public CollisionDetector collisionDetector = new CollisionDetector(this);
  public GameWorld gameWorld = new GameWorld(this);
  Random random = new Random();
  public UI ui = new UI(this);

  // public EventHandler eventHandler = new EventHandler(this);
  public boolean gameOver = false;
  public boolean victory = false;
  public long gameTime;

  /*
   * Constructor for GameEngine class that takes in a GameObjectFactory
   */
  public GameEngine(GameObjectFactory factoryMethod) {
    // Set the Screen Size
    screenSetUp();
    this.gameObjectFactory = factoryMethod;
    this.mainChar = gameObjectFactory.createMainCharacter(this);
    objectsCreator(factoryMethod);
  }

  public void objectsCreator(GameObjectFactory factoryMethod) {
    this.gameObjectFactory = factoryMethod;
    this.bonusRewards = gameObjectFactory.createBonusRewards(this);
    this.staticRewards = gameObjectFactory.createStaticRewards(this);
    this.movingEnemy = gameObjectFactory.createMovingEnemy(this);
    this.staticEnemy = gameObjectFactory.createStaticEnemy(this);

    // Add static and moving enemies to their respective lists
    for (int i = 0; i < 10; i++) {
      StaticEnemy staticEnemy = gameObjectFactory.createStaticEnemy(this);
      staticEnemies.add(staticEnemy);
    }
    for (int i = 0; i < 4; i++) {
      MovingEnemy movingEnemy = gameObjectFactory.createMovingEnemy(this);
      movingEnemies.add(movingEnemy);
    }
    for (int i = 0; i < 5; i++) {
      StaticRewards staticReward = gameObjectFactory.createStaticRewards(this);
      staticRewardsList.add(staticReward);
    }

    this.bonusReward = gameObjectFactory.createBonusRewards(this);
  }

  /*
   * Set the screen size and background color
   */
  public void screenSetUp() {
    setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    this.addKeyListener(keyBoard);
    setFocusable(true);
    requestFocus();
  }

  /*
   * Paint the game every frame by calling the draw method in the MainCharacter
   * class
   */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    // Calling MainCharacter class to draw the character

    gameWorld.draw(g2d, cellSize);
    mainChar.draw(g2d);

    // Draw the moving enemies
    for (MovingEnemy movingEnemy : movingEnemies) {
      movingEnemy.draw(g2d);
    }

    // Draw the static enemies
    for (StaticEnemy staticEnemy : staticEnemies) {
      staticEnemy.draw(g2d);
    }

    for (StaticRewards staticReward : staticRewardsList) {
      staticReward.draw(g2d);
    }

    bonusReward.draw(g2d);

    ui.draw(g2d);
    g2d.dispose();
  }

  public void startGameThread() {
    gameThread = new Thread(this);
    gameThread.start();
  }

  /*
   * Creating a Game Loop to update the game every 60 frames per second
   */
  @Override
  public void run() {
    final int FPS = 60;
    final double timePerTick = 1_000_000_000.0 / FPS;
    double nextDraw = System.nanoTime() + timePerTick;
    int startTime = (int) System.currentTimeMillis();
    long lastTime = System.nanoTime();

    final double updateInterval = 0.4; // set enemy update interval to 1 second
    double timeSinceLastUpdate = 0;

    final double movementInterval = 0.2; // set movement interval to 0.1 seconds
    double timeSinceLastMove = 0;

    while (gameThread != null) {
      long currentTime = System.nanoTime();
      double elapsedTime = (currentTime - lastTime) / 1_000_000_000.0; // convert to seconds
      long screenTime = (System.currentTimeMillis() - startTime);
      gameTime = (int) (screenTime);
      lastTime = currentTime;

      if (isMovementKeyPressed()) {
        timeSinceLastMove += elapsedTime;
        if (timeSinceLastMove >= movementInterval) {
          mainChar.update(keyBoard);
          timeSinceLastMove = 0;
        }
      }

      timeSinceLastUpdate += elapsedTime;
      if (timeSinceLastUpdate >= updateInterval) {
        updateEnemies(updateInterval);
        updateTimeSensitiveObjects();
        timeSinceLastUpdate = 0;
      }

      repaint();

      if (gameWorld.updateCellProperties(mainChar) == true) {
        gameWorld.map = 1;
        gameWorld.changeMap();
        resetGame();

      }

      sleepThread(nextDraw, timePerTick);

      nextDraw += timePerTick;
    }
  }

  public void resetGame() {
    clearObjects();
    objectsCreator(gameObjectFactory);
  }

  public void clearObjects() {
    this.bonusRewards = null;
    this.staticRewards = null;
    this.movingEnemy = null;
    this.staticEnemy = null;
    this.staticEnemies.clear();
    this.movingEnemies.clear();
    this.staticRewardsList.clear();
  }

  private boolean isMovementKeyPressed() {
    return keyBoard.upPressed || keyBoard.leftPressed || keyBoard.rightPressed || keyBoard.downPressed;
  }

  private void updateEnemies(double updateInterval) {
    for (MovingEnemy enemy : movingEnemies) {
      enemy.update(updateInterval, mainChar);
    }
    for (StaticEnemy enemy : staticEnemies) {
      enemy.update(mainChar);
    }
  }

  private void updateTimeSensitiveObjects() {
    for (StaticRewards staticReward : staticRewardsList) {
      staticReward.update(mainChar);
    }
    bonusReward.update(mainChar);
  }

  private void sleepThread(double nextDraw, double timePerTick) {
    try {
      long remainingTime = (long) ((nextDraw - System.nanoTime()) / 1_000_000);
      if (remainingTime > 0) {
        Thread.sleep(remainingTime);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void victory() {
    victory = true;
    ui.victory = true;
    repaint();

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    PlayScreen playScreen = new PlayScreen();
    playScreen.setVisible(true);
    // Close the current game screen
    gameThread = null;
    setVisible(false);
    dispose();
  }

  public void gameOver() {
    gameOver = true;
    ui.gameOver = true;
    repaint();

    // Delay the screen transition for 5 seconds
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    PlayScreen playScreen = new PlayScreen();
    playScreen.setVisible(true);
    // Close the current game screen
    gameThread = null;
    setVisible(false);
    dispose();
  }

  private void dispose() {
    // Find the top-level JFrame
    javax.swing.JFrame frame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);

    // Dispose the JFrame
    if (frame != null) {
      frame.dispose();
    }
  }

}
