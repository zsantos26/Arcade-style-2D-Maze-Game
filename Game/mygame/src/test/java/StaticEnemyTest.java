import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.abstractfactory.AbstractFactory;
import com.example.abstractfactory.GameObjectFactory;
import com.example.characters.MainCharacter;
import com.example.characters.StaticEnemy;
import com.example.game.GameEngine;

public class StaticEnemyTest {

    private StaticEnemy enemy;
    private MainCharacter mainChar;

    @Before
    public void setUp() {
        GameObjectFactory gameObjectFactory = new AbstractFactory();
        GameEngine gameEngine = new GameEngine(gameObjectFactory);
        gameEngine.startGameThread();
        mainChar = gameEngine.mainChar;
        enemy = gameEngine.staticEnemy;
    }

    @Test
    public void testVisibleGetterAndSetter() {
        enemy.setVisible(true);
        assertTrue(enemy.isVisible());
        enemy.setVisible(false);
        assertFalse(enemy.isVisible());
    }


    @Test
    public void testDamageAmountGetterAndSetter() {
        enemy.setDamageAmount(30);
        assertEquals(30, enemy.getDamageAmount());
        enemy.setDamageAmount(60);
        assertEquals(60, enemy.getDamageAmount());
    }

    @Test
    public void testIsDetectedGetterAndSetter() {
        enemy.setDetected(true);
        assertTrue(enemy.isDetected());
        enemy.setDetected(false);
        assertFalse(enemy.isDetected());
    }
    
    @Test
    public void testSpawning() {
        assertFalse(enemy.isVisible()); // should not be visible at the beginning
        enemy.setX(50); // move enemy to (50, 0)
        enemy.setY(50); // move enemy to (50, 50)
        enemy.spawning(); // should relocate to a different position
        assertFalse(enemy.checkCollision()); // should not collide with any barriers
    }

    @Test
    public void testGetStaticEnemySprite() {
        assertNotNull(enemy.staticEnemy1);
        assertNotNull(enemy.staticEnemy2);
    }

    @Test
    public void testUpdate() {
        enemy.setX(50); // move enemy to (50, 0)
        enemy.setY(50); // move enemy to (50, 50)
        mainChar.setX(40); // move main character to (40, 0)
        mainChar.setY(40); // move main character to (40, 40)
        enemy.update(mainChar); // should relocate to a different position
        assertTrue(enemy.checkCollision()); // should collide with the main character
    }
    
}
