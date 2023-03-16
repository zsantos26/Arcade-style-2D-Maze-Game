package com.example.abstractfactory;

import com.example.characters.BonusRewards;
import com.example.characters.MainCharacter;
import com.example.characters.MovingEnemy;
import com.example.characters.StaticEnemy;
import com.example.characters.StaticRewards;
import com.example.game.CollisionDetector;
import com.example.game.GameEngine;

public class RewardsFactory implements GameObjectFactory {
    GameEngine gameBarrier;
    CollisionDetector colli;
    @Override
    public MainCharacter createMainCharacter(GameEngine gameEngine) {
        return null; // implementation for main character not provided
    }

    @Override
    public MovingEnemy createMovingEnemy(GameEngine gameEngine) {
        return null; // implementation for moving enemy not provided
    }

    @Override
    public StaticEnemy createStaticEnemy(GameEngine gameEngine) {
        return null; // implementation for static enemy not provided
    }

    @Override
    public StaticRewards createStaticRewards(GameEngine gameEngine) {
        this.gameBarrier = gameEngine;
        return new StaticRewards(50, 0, 912, gameBarrier);
    }

    @Override
    public BonusRewards createBonusRewards(GameEngine gameEngine) {
        this.gameBarrier = gameEngine;
        return new BonusRewards(50, 0, 912, 4, gameBarrier);
    }
}