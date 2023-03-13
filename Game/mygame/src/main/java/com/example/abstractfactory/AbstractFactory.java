package com.example.abstractfactory;
import com.example.characters.BonusRewards;
import com.example.characters.MainCharacter;
import com.example.characters.MovingEnemy;
import com.example.characters.StaticEnemy;
import com.example.characters.StaticRewards;
import com.example.game.GameEngine;


public class AbstractFactory implements GameObjectFactory {
    GameEngine gameBarrier;
    @Override
    public MainCharacter createMainCharacter(GameEngine gameEngine) {
        this.gameBarrier = gameEngine;
        return new MainCharacter(0, 48, gameBarrier);
    }

    @Override
    public MovingEnemy createMovingEnemy() {
        return new MovingEnemy(3,3,10);
    }

    @Override
    public StaticEnemy createStaticEnemy() {
        return new StaticEnemy(10,10,20);
    }

    @Override
    public StaticRewards createStaticRewards() {
        return new StaticRewards(20, 3, 4);
    }

    @Override
    public BonusRewards createBonusRewards() {
        return new BonusRewards(50, 5, 5, 2);
    }
}
