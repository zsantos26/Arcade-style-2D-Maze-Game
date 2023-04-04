
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
    public void testGetRewardAmount() {
        Assert.assertEquals(100, this.rewards.getRewardAmount());
    }

    @Test
    public void testSetRewardAmount() {
        rewards.setRewardAmount(100);
        Assert.assertEquals(100, this.rewards.getRewardAmount());
    }
    @Test
    public void testOnReward() {
        Assert.assertTrue(this.rewards.onReward(0, 0));
        Assert.assertFalse(this.rewards.onReward(1, 1));
    }

    @Test
    public void testClaimReward() {
        this.rewards.claimReward(mainChar);
        Assert.assertTrue(this.rewards.isCollected());
        Assert.assertEquals(50, mainChar.score);
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
