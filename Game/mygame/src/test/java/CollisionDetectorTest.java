
import static org.junit.Assert.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.abstractfactory.AbstractFactory;
import com.example.abstractfactory.GameObjectFactory;
import com.example.game.Cells;
import com.example.game.CollisionDetector;
import com.example.game.GameEngine;
import com.example.game.GameWorld;
import com.example.characters.MainCharacter;

public class CollisionDetectorTest {
    private CollisionDetector collisionDetector;
    private GameEngine gameEngine;
    private GameWorld gameWorld;

    @Before
    public void setUp() {
        GameObjectFactory gameObjectFactory = new AbstractFactory();
        gameEngine = new GameEngine(gameObjectFactory);
        gameWorld = new GameWorld(gameEngine);
        collisionDetector = new CollisionDetector(gameEngine);
    }

    @Test
    public void testCheckCellsNoCollision() {
        MainCharacter mainChar = new MainCharacter(0, 0, gameEngine);
        boolean result = collisionDetector.checkCells(mainChar);
        assertFalse(result);
    }

    @Test
    public void testCheckCellsCollision() {
        // Set up a collision cell in the game world
        gameWorld.mapCells[0][0] = 1;
        Cells cell = new Cells();
        cell.collision = true;
        gameWorld.cell[1] = cell;

        // Test collision detection
        MainCharacter character = new MainCharacter(0, 0, gameEngine);
        boolean result = collisionDetector.checkCells(character);
        assertTrue(result);
    }

    @Test
    public void testCheckCellsOutOfBounds() {
        MainCharacter character = new MainCharacter(-1, 0, gameEngine);
        boolean result = collisionDetector.checkCells(character);
        assertTrue(result);
    }

    @Test
    public void testCheckCellsPortal() {
        // Set up a portal cell in the game world
        gameWorld.mapCells[0][0] = 1;
        Cells cell = new Cells();
        cell.portal = true;
        gameWorld.cell[1] = cell;

        // Test portal behavior
        MainCharacter character = new MainCharacter(0, 0, gameEngine);
        boolean result = collisionDetector.checkCells(character);
        assertFalse(result);
        assertEquals(1, gameWorld.map);
        assertFalse(cell.portal);
    }
}
