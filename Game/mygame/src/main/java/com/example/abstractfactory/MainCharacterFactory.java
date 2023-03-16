package com.example.abstractfactory;

import com.example.characters.BonusRewards;
import com.example.characters.MainCharacter;
import com.example.characters.MovingEnemy;
import com.example.characters.StaticEnemy;
import com.example.characters.StaticRewards;
import com.example.game.GameEngine;

public class MainCharacterFactory implements GameObjectFactory {
    GameEngine gameBarrier;
    @Override
    public MainCharacter createMainCharacter(GameEngine gameEngine) {
        this.gameBarrier = gameEngine;
        return new MainCharacter(0,0, gameBarrier);
    }
    
    @Override
    public MovingEnemy createMovingEnemy(GameEngine gameEngine) {
        // not implemented in this factory
        return null;
    }

    @Override
    public StaticEnemy createStaticEnemy(GameEngine gameEngine) {
        // not implemented in this factory
        return null;
    }
    
    @Override
    public StaticRewards createStaticRewards(GameEngine gameEngin) {
        // not implemented in this factory
        return null;
    }

    @Override
    public BonusRewards createBonusRewards(GameEngine gameEngine) {
        // not implemented in this factory
        return null;
    }
}
