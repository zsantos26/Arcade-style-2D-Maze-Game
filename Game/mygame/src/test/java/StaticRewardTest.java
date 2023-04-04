
import com.example.abstractfactory.AbstractFactory;
import com.example.abstractfactory.GameObjectFactory;
import com.example.characters.MainCharacter;
import com.example.characters.StaticRewards;
import com.example.game.GameEngine;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

public class StaticRewardTest {
    private StaticRewards rewards;
    private MainCharacter mainChar;
    public StaticRewardTest(){
    }

    @Before
    public void setUp() {
        GameObjectFactory gameObjectFactory = new AbstractFactory();
        GameEngine gameEngine = new GameEngine(gameObjectFactory);
        gameEngine.startGameThread();
        this.mainChar = gameEngine.mainChar;
        this.rewards = gameEngine.staticRewards;
    }

    @Test
    public void testSetRewardAmount() {
        rewards.setRewardAmount(100);
        Assert.assertEquals(100, this.rewards.getRewardAmount());
    }

    @Test
    public void testSpawning() {
        rewards.setX(50); // move rewards to (50, 0)
        rewards.setY(50); // move rewards to (50, 50)
        rewards.spawning(); // should relocate to a different position
        assertFalse(rewards.checkCollision()); // should not collide with any barriers
    }
    @Test
    public void testGetStaticRewardsSprite() {
        assertNotNull(rewards.staticReward1);
        assertNotNull(rewards.staticReward2);
    }
    @Test
    public void testCheckCollision() {
        rewards.setX(50); // move rewards to (50, 0)
        rewards.setY(50); // move rewards to (50, 50)
        mainChar.setX(50); // move main character to (50, 0)
        mainChar.setY(50); // move main character to (50, 50)
        assertTrue(rewards.checkCollision()); // should collide with the main character
    }

    @Test
    public void testClaimReward() {
        rewards.setRewardAmount(100);
        rewards.setX(50); // move rewards to (50, 0)
        rewards.setY(50); // move rewards to (50, 50)
        mainChar.setX(50); // move main character to (50, 0)
        mainChar.setY(50); // move main character to (50, 50)
        mainChar.score = 0;
        rewards.update(mainChar);
        Assert.assertEquals(100, mainChar.score);
    }

    @Test
    public void testDraw() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/images/book/note.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Graphics2D graphics = image.createGraphics();
        this.rewards.draw(graphics);
        Assert.assertNotNull(image);
    }


}
