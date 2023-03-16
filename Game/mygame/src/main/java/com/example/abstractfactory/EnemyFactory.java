package com.example.abstractfactory;
import com.example.characters.BonusRewards;
import com.example.characters.MainCharacter;
import com.example.characters.MovingEnemy;
import com.example.characters.StaticEnemy;
import com.example.characters.StaticRewards;
import com.example.game.CollisionDetector;
import com.example.game.GameEngine;

public class EnemyFactory implements GameObjectFactory {
    GameEngine gameBarrier;

    @Override
    public MainCharacter createMainCharacter(GameEngine gameEngine) {
        return null; // implementation for main character not provided
    }

    @Override
    public MovingEnemy createMovingEnemy(GameEngine gameEngine) {
        this.gameBarrier = gameEngine;
        return new MovingEnemy(480, 480, 900, gameBarrier);
    }

    @Override
    public StaticEnemy createStaticEnemy(GameEngine gameEngine) {
        return new StaticEnemy(19,19,49, gameEngine);
    }

    @Override
    public StaticRewards createStaticRewards(GameEngine gameEngine) {
        return null; // implementation for static rewards not provided
    }

    @Override
    public BonusRewards createBonusRewards(GameEngine gameEngine) {
        return null; // implementation for bonus rewards not provided
    }
}
