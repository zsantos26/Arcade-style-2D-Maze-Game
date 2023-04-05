import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
  public void testObjectsCreator() {
    // Clear objects to ensure the initial state is empty
    gameEngine.clearObjects();
  
    // Call the objectsCreator method with the factory
    GameObjectFactory factoryMethod = new AbstractFactory();
    gameEngine.objectsCreator(factoryMethod);
  
    // Check if the game objects are created and not null
    assertNotNull(gameEngine.bonusRewards);
    assertNotNull(gameEngine.staticRewards);
    assertNotNull(gameEngine.movingEnemy);
    assertNotNull(gameEngine.staticEnemy);
  
    // Check if the correct number of objects are added to the lists
    assertEquals(10, gameEngine.staticEnemies.size());
    assertEquals(4, gameEngine.movingEnemies.size());
    assertEquals(5, gameEngine.staticRewardsList.size());
  
    // Check if the bonusReward object is created
    assertNotNull(gameEngine.bonusReward);
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

  @Test
  public void testVictory() {
      // Set the game state to victory
      gameEngine.victory();

      // Check if the victory flag is set
      assertTrue(gameEngine.victory);

      // Check if the UI's victory flag is set
      assertTrue(gameEngine.ui.victory);
  }

  @Test
  public void testGameOver() {
      // Call the gameOver method
      gameEngine.gameOver();
  
      // Check if the gameOver flag is set
      assertTrue(gameEngine.gameOver);
  
      // Check if the UI's gameOver flag is set
      assertTrue(gameEngine.ui.gameOver);
  }

  @Test
  public void testClearObjects() {
    // Check if the game objects are not null before clearing
    assertNotNull(gameEngine.bonusRewards);
    assertNotNull(gameEngine.staticRewards);
    assertNotNull(gameEngine.movingEnemy);
    assertNotNull(gameEngine.staticEnemy);
    assertFalse(gameEngine.staticEnemies.isEmpty());
    assertFalse(gameEngine.movingEnemies.isEmpty());
    assertFalse(gameEngine.staticRewardsList.isEmpty());
  
    gameEngine.clearObjects();
  
    // Check if the game objects are null after clearing
    assertNull(gameEngine.bonusRewards);
    assertNull(gameEngine.staticRewards);
    assertNull(gameEngine.movingEnemy);
    assertNull(gameEngine.staticEnemy);
    assertTrue(gameEngine.staticEnemies.isEmpty());
    assertTrue(gameEngine.movingEnemies.isEmpty());
    assertTrue(gameEngine.staticRewardsList.isEmpty());
  }

  

}
