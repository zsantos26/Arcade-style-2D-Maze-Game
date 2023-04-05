import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import com.example.abstractfactory.AbstractFactory;
import com.example.abstractfactory.GameObjectFactory;
import com.example.characters.MainCharacter;
import com.example.game.Cells;
import com.example.game.GameEngine;
import com.example.game.GameWorld;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import javafx.scene.control.Cell;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameWorldTest {
    private GameWorld gameWorld;
    private Cells[] cell;
    private MainCharacter mainChar;

    public GameWorldTest(){

    }

//    @Before
//    public void setUp() {
//        GameEngine gameEngine = new GameEngine();
//        gameWorld = new GameWorld(gameEngine);
//        cell = gameWorld.cell; //
//        this.mainChar = gameEngine.mainChar;
//
//    }
    @Test
    public void testDrawMap() {
        // Create a test map file
        String testMap = "testMap.txt";
        try (PrintWriter out = new PrintWriter(testMap)) {
            out.println("1 2 3");
            out.println("4 5 6");
            out.println("7 8 9");
        } catch (Exception e) {
            fail("Failed to create test map file");
        }

        // Call drawMap with the test map file
        gameWorld.drawMap("testMap.txt");

        // Check that mapCells has been populated with the expected values
        long[][] mapCells = new long[0][];
        assertEquals(1, mapCells[0][0]);
        assertEquals(2, mapCells[1][0]);
        assertEquals(3, mapCells[2][0]);
        assertEquals(4, mapCells[0][1]);
        assertEquals(5, mapCells[1][1]);
        assertEquals(6, mapCells[2][1]);
        assertEquals(7, mapCells[0][2]);
        assertEquals(8, mapCells[1][2]);
        assertEquals(9, mapCells[2][2]);
    }



    //check if the first map is "/maps/Map_Class.txt"
    @Test
    public void TestGameWorld(){

    }
    @Test
    //check if map changed to "/maps/Map_AQ.txt"
    public void testChangeMap(){

    }

//    @Test
//    public void testClaimReward() {
//
//        //move main char to portal to see if it goes to the next map
//        mainChar.setX(50); // move main character to (50, 0)
//        mainChar.setY(50); // move main character to (50, 50)
//        mainChar.score = 600;
//        Assert.assertEquals(600, mainChar.score);
//
//
//        assertTrue(map == 1);
//    }






}
