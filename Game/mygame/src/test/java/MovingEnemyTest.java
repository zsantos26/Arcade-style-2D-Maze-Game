import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.abstractfactory.AbstractFactory;
import com.example.abstractfactory.GameObjectFactory;
import com.example.characters.MainCharacter;
import com.example.characters.MovingEnemy;
import com.example.game.GameEngine;

public class MovingEnemyTest {

    private MovingEnemy enemy;
    private MainCharacter mainChar;

    @Before
    public void setUp() {
        GameObjectFactory gameObjectFactory = new AbstractFactory();
        GameEngine gameEngine = new GameEngine(gameObjectFactory);
        gameEngine.startGameThread();
        mainChar = gameEngine.mainChar;
        enemy = new MovingEnemy(50, 50, 30, gameEngine);
    }

    @Test
    public void testDamageAmountGetterAndSetter() {
        enemy.setDamageAmount(30);
        assertEquals(30, enemy.getDamageAmount());
        enemy.setDamageAmount(60);
        assertEquals(60, enemy.getDamageAmount());
    }

    @Test
    public void testSpawning() {
        enemy.spawning();
        assertFalse(enemy.checkCollision());
    }

    @Test
    public void testMoveTowards() {
        mainChar.setX(40);
        mainChar.setY(40);
        String direction = enemy.moveTowards(mainChar);
        assertTrue(direction.equals("up") || direction.equals("left"));
    }

    @Test
    public void testMoveTowardsAlt() {
        mainChar.setX(40);
        mainChar.setY(40);
        String direction = enemy.moveTowardsAlt(mainChar);
        assertTrue(direction.equals("up") || direction.equals("left"));
    }

    @Test
    public void testUpdate() {
        mainChar.setX(90);
        mainChar.setY(50);
        enemy.update(0.016, mainChar);
        assertEquals(90, enemy.getX());
        assertEquals(50, enemy.getY());
    }
}
