package com.example.abstractfactory;
import com.example.characters.BonusRewards;
import com.example.characters.MainCharacter;
import com.example.characters.MovingEnemy;
import com.example.characters.StaticEnemy;
import com.example.characters.StaticRewards;
import com.example.game.CollisionDetector;
import com.example.game.GameEngine;

public class EnemyFactory implements GameObjectFactory {

    @Override
    public MainCharacter createMainCharacter(GameEngine gameEngine) {
        return null; // implementation for main character not provided
    }

    @Override
    public MovingEnemy createMovingEnemy() {
        return new MovingEnemy(2,2,3);
    }

    @Override
    public StaticEnemy createStaticEnemy() {
        return new StaticEnemy(19,19,49);
    }

    @Override
    public StaticRewards createStaticRewards(GameEngine gameEngine, CollisionDetector collisionDetector) {
        return null; // implementation for static rewards not provided
    }

    @Override
    public BonusRewards createBonusRewards(GameEngine gameEngine, CollisionDetector collisionDetector) {
        return null; // implementation for bonus rewards not provided
    }
}
