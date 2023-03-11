package com.example.abstractfactory;

import com.example.characters.BonusRewards;
import com.example.characters.MainCharacter;
import com.example.characters.MovingEnemy;
import com.example.characters.StaticEnemy;
import com.example.characters.StaticRewards;

public class MainCharacterFactory implements GameObjectFactory {
    
    @Override
    public MainCharacter createMainCharacter() {
        return new MainCharacter(0,0);
    }
    
    @Override
    public MovingEnemy createMovingEnemy() {
        // not implemented in this factory
        return null;
    }

    @Override
    public StaticEnemy createStaticEnemy() {
        // not implemented in this factory
        return null;
    }
    
    @Override
    public StaticRewards createStaticRewards() {
        // not implemented in this factory
        return null;
    }

    @Override
    public BonusRewards createBonusRewards() {
        // not implemented in this factory
        return null;
    }
}
