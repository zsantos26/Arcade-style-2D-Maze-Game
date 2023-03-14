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
    public MovingEnemy createMovingEnemy() {
        return null; // implementation for moving enemy not provided
    }

    @Override
    public StaticEnemy createStaticEnemy() {
        return null; // implementation for static enemy not provided
    }

    @Override
    public StaticRewards createStaticRewards() {
        return new StaticRewards(0,0,0);
    }

    @Override
    public BonusRewards createBonusRewards(GameEngine gameEngine, CollisionDetector collisionDetector) {
        this.gameBarrier = gameEngine;
        this.colli = collisionDetector;
        return new BonusRewards(50, 0, 912, 4, gameBarrier, colli);
    }
}