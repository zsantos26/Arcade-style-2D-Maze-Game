import static org.junit.Assert.*;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.Before;
import org.junit.Test;

import com.example.abstractfactory.AbstractFactory;
import com.example.abstractfactory.GameObjectFactory;
import com.example.characters.MainCharacter;
import com.example.game.GameEngine;
import com.example.game.GameInput;

public class MainCharacterTest {

    private MainCharacter mainChar;

    @Before
    public void setUp() {
        GameObjectFactory gameObjectFactory = new AbstractFactory();
        GameEngine gameEngine = new GameEngine(gameObjectFactory);
        gameEngine.startGameThread();
        mainChar = gameEngine.mainChar;
    }

    @Test
    public void testScoreGetterAndSetter() {
        mainChar.setScore(100);
        assertEquals(100, mainChar.getScore());
        mainChar.setScore(200);
        assertEquals(200, mainChar.getScore());
    }

    // Test getPlayerSprite method
    @Test
    public void testGetPlayerSprite() {
        assertNotNull(mainChar.up1);
        assertNotNull(mainChar.up2);
        assertNotNull(mainChar.down1);
        assertNotNull(mainChar.down2);
        assertNotNull(mainChar.left1);
        assertNotNull(mainChar.left2);
        assertNotNull(mainChar.right1);
        assertNotNull(mainChar.right2);
    }

    @Test
    public void testUpdateMoveUp() {
        // create a mock GameInput object with upPressed = true and other properties =
        // false
        GameInput mockInput = new GameInput();
        mockInput.upPressed = true;

        mainChar.setX(5);
        mainChar.setY(5);
        mainChar.update(mockInput);

        // check that the moveUp method was called
        assertEquals("up", mainChar.direction);
    }

    @Test
    public void testUpdateMoveDown() {
        // create a mock GameInput object with upPressed = true and other properties =
        // false
        GameInput mockInput = new GameInput();
        mockInput.downPressed = true;

        mainChar.setX(5);
        mainChar.setY(5);
        mainChar.update(mockInput);

        // check that the moveDown method was called
        assertEquals("down", mainChar.direction);
    }

    @Test
    public void testUpdateMoveLeft() {
        // create a mock GameInput object with upPressed = true and other properties =
        // false
        GameInput mockInput = new GameInput();
        mockInput.leftPressed = true;

        mainChar.setX(5);
        mainChar.setY(5);
        mainChar.update(mockInput);

        // check that the moveLeft method was called
        assertEquals("left", mainChar.direction);
    }

    @Test
    public void testUpdateMoveRight() {
        // create a mock GameInput object with upPressed = true and other properties =
        // false
        GameInput mockInput = new GameInput();
        mockInput.rightPressed = true;

        mainChar.setX(5);
        mainChar.setY(5);
        mainChar.update(mockInput);

        // check that the moveRight method was called
        assertEquals("right", mainChar.direction);
    }

}
