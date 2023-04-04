import static org.junit.Assert.*;

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


    @Test
    public void testUpdateMoveUp() {
        // create a mock GameInput object with upPressed = true and other properties = false
        GameInput mockInput = new GameInput();
        mockInput.upPressed = true;

        mainChar.setX(5);
        mainChar.setX(5);
        mainChar.update(mockInput);
    
        // check that the moveUp method was called
        assertEquals("up", mainChar.direction);
    }
    

}
