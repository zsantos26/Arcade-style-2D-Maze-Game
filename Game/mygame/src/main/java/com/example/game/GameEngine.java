package com.example.game;

import javax.swing.JPanel;
import com.example.abstractfactory.GameObjectFactory;
import com.example.characters.BonusRewards;
import com.example.characters.MainCharacter;
import com.example.characters.MovingEnemy;
import com.example.characters.StaticRewards;
import java.util.Random;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GameEngine extends JPanel implements Runnable{
  //Set the Screen Size
  final int originalCellSize = 16; //20x20 Cells
  final int scale = 3;
  //Screen Dimensions
  public final int cellSize = originalCellSize * scale;
  public final int maxScreenCol = 20;
  public final int maxScreenRow = 20;
  public final int screenWidth = cellSize * maxScreenCol;
  public final int screenHeight = cellSize * maxScreenRow;

  public final int maxMap = 3;
  public final int currentMap=0;


  //Abstract Factory
  private GameObjectFactory gameObjectFactory;
  private MainCharacter mainChar;
  private BonusRewards bonusRewards;
  private StaticRewards staticRewards;
  private MovingEnemy movingEnemy;

  //Keyboard Input
  GameInput keyBoard = new GameInput();
  Thread gameThread;
  public CollisionDetector collisionDetector = new CollisionDetector(this);
  GameWorld gameWorld = new GameWorld(this);
  Random random = new Random();

  /*
  Constructor for GameEngine class that takes in a GameObjectFactory
   */
  public GameEngine(GameObjectFactory factoryMethod) {
    //Set the Screen Size
    screenSetUp();
    this.gameObjectFactory = factoryMethod;
    this.mainChar = gameObjectFactory.createMainCharacter(this);
    this.bonusRewards = gameObjectFactory.createBonusRewards(this, collisionDetector);
    this.staticRewards = gameObjectFactory.createStaticRewards(this, collisionDetector);
    this.movingEnemy = gameObjectFactory.createMovingEnemy(this);
  }

  /*
  Set the screen size and background color
   */
  public void screenSetUp(){
    setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    this.addKeyListener(keyBoard);
    setFocusable(true);
    requestFocus();
  }

  /*
  Paint the game every frame by calling the draw method in the MainCharacter class
   */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    //Calling MainCharacter class to draw the character
    gameWorld.draw(g2d, cellSize);
    mainChar.draw(g2d);
    movingEnemy.draw(g2d);
    bonusRewards.draw(g2d);
    staticRewards.draw(g2d);
    g2d.dispose();
  }

  public void startGameThread(){
    gameThread = new Thread(this);
    gameThread.start();
  }

  /*
  Creating a Game Loop to update the game every 60 frames per second
  */
  @Override
  public void run() {
    int FPS = 60;
    double timePerTick = 1000000000 / FPS;
    double nextDraw = System.nanoTime() + timePerTick;
    long lastTime = System.nanoTime();

    while (gameThread != null) {
      // long currTime = System.nanoTime();
      // System.out.println(currTime);
      // System.out.println("Game Thread is running");
      long currentTime = System.nanoTime();
      double elapsed = (currentTime - lastTime) / 1000000000.0; // convert to seconds
      lastTime = currentTime;
      if(keyBoard.upPressed == false && keyBoard.leftPressed == false && keyBoard.rightPressed == false && keyBoard.downPressed == false){
        repaint();
      }
      else{
        update(elapsed);
        repaint();
      }
      try{
        double remainingTime = nextDraw - System.nanoTime();
        remainingTime = remainingTime/1000000;
        if(remainingTime < 0){
          remainingTime = 0;
        }
        Thread.sleep((long) remainingTime); //casting
        nextDraw += timePerTick;
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  /*
  Update the game every frame by calling the update method in the MainCharacter class
  */
  public void update(double elapsed) {
    mainChar.update(keyBoard,elapsed);
    movingEnemy.update(elapsed, mainChar);
    bonusRewards.update();
    staticRewards.update();
  }
}
