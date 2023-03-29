package com.example.abstractfactory;

import java.util.Random;

import com.example.characters.BonusRewards;
import com.example.characters.MainCharacter;
import com.example.characters.MovingEnemy;
import com.example.characters.StaticEnemy;
import com.example.characters.StaticRewards;
import com.example.game.CollisionDetector;
import com.example.game.GameEngine;

public class AbstractFactory implements GameObjectFactory {
    GameEngine gameBarrier;
    CollisionDetector colli;
    Random random = new Random();

    @Override
    public MainCharacter createMainCharacter(GameEngine gameEngine) {
        this.gameBarrier = gameEngine;
        return new MainCharacter(0, 48, gameBarrier);
    }

    @Override
    public MovingEnemy createMovingEnemy(GameEngine gameEngine) {
        this.gameBarrier = gameEngine;
        int x = random.nextInt(20);
        int y = random.nextInt(20);
        x = x * gameEngine.cellSize;
        y = y * gameEngine.cellSize;
        MovingEnemy movingEnemy = new MovingEnemy(x, y, 900, gameBarrier);
        if (movingEnemy.checkCollision() == true || x / gameBarrier.cellSize < 2) {
            movingEnemy.spawning();
        }
        return movingEnemy;
    }

    @Override
    public StaticEnemy createStaticEnemy(GameEngine gameEngine) {
        this.gameBarrier = gameEngine;
        int x = random.nextInt(20);
        int y = random.nextInt(20);
        x = x * gameEngine.cellSize;
        y = y * gameEngine.cellSize;
        StaticEnemy staticEnemy = new StaticEnemy(x, y, 20, gameEngine);
        if (staticEnemy.checkCollision() == true || x / gameBarrier.cellSize < 2) {
            staticEnemy.spawning();
        }
        return staticEnemy;
    }

    @Override
    public StaticRewards createStaticRewards(GameEngine gameEngine) {
        this.gameBarrier = gameEngine;
        int x = random.nextInt(20);
        int y = random.nextInt(20);
        x = x * gameEngine.cellSize;
        y = y * gameEngine.cellSize;
        StaticRewards staticRewards = new StaticRewards(100, x, y, gameEngine);
        if (staticRewards.checkCollision() == true) {
            staticRewards.spawning();
        }
        return staticRewards;
    }

    @Override
    public BonusRewards createBonusRewards(GameEngine gameEngine) {
        this.gameBarrier = gameEngine;
        int x = random.nextInt(20);
        int y = random.nextInt(20);
        x = x * gameEngine.cellSize;
        y = y * gameEngine.cellSize;
        BonusRewards bonusRewards = new BonusRewards(200, x, y, 2, gameEngine);
        if (bonusRewards.checkCollision() == true) {
            bonusRewards.spawning();
        }
        return bonusRewards;
    }
}
