import com.example.abstractfactory.AbstractFactory;
import com.example.abstractfactory.GameObjectFactory;
import com.example.characters.MainCharacter;
import com.example.characters.BonusRewards;
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
public class BonusRewardsTest {
    private BonusRewards bonusRewards;
    private MainCharacter mainChar;

    public BonusRewardsTest(){
    }
    @Before
    public void setUp() {
        GameObjectFactory gameObjectFactory = new AbstractFactory();
        GameEngine gameEngine = new GameEngine(gameObjectFactory);
        gameEngine.startGameThread();
        this.mainChar = gameEngine.mainChar;
        this.bonusRewards = gameEngine.bonusRewards;
    }


}
