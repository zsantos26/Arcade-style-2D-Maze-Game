import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import org.junit.Before;
import org.junit.Test;

import com.example.abstractfactory.AbstractFactory;
import com.example.abstractfactory.GameObjectFactory;
import com.example.game.GameEngine;

public class GameEngineTest {
  private GameEngine gameEngine;


  @Before
  public void setUp() {
    GameObjectFactory gameObjectFactory = new AbstractFactory();
    gameEngine = new GameEngine(gameObjectFactory);
    gameEngine.startGameThread();

  }

  @Test
  public void testScreenSetUp() {
    gameEngine.screenSetUp();
    assertEquals(gameEngine.getPreferredSize().width, gameEngine.screenWidth);
    assertEquals(gameEngine.getPreferredSize().height, gameEngine.screenHeight);
    assertEquals(gameEngine.getBackground(), java.awt.Color.BLACK);
    assertNotNull(gameEngine.getKeyListeners());
  }

  @Test
  public void testPaintComponent() {
    JFrame frame = new JFrame();
    frame.add(gameEngine);
    frame.pack();
    frame.setVisible(true);
    Graphics g = gameEngine.getGraphics();
    assertNotNull(g);
    assertTrue(g instanceof Graphics2D);
    gameEngine.paintComponent(g);
  }

  @Test
  public void testResetGame() {
    gameEngine.resetGame();
    assertNotNull(gameEngine.mainChar);
    assertNotNull(gameEngine.bonusRewards);
    assertNotNull(gameEngine.staticRewards);
    assertNotNull(gameEngine.movingEnemy);
    assertNotNull(gameEngine.staticEnemy);
  }

  @Test
  public void testUpdateEnemies() {
    GameObjectFactory gameObjectFactory = new AbstractFactory();
    GameEngine gameEngine = new GameEngine(gameObjectFactory);
    gameEngine.startGameThread();
    double updateInterval = 0.4;
    int numMovingEnemies = gameEngine.movingEnemies.size();
    gameEngine.updateEnemies(updateInterval);
    assertEquals(numMovingEnemies, gameEngine.movingEnemies.size());
    int numStaticEnemies = gameEngine.staticEnemies.size();
    gameEngine.updateEnemies(updateInterval);
    assertEquals(numStaticEnemies, gameEngine.staticEnemies.size());
  }





}
