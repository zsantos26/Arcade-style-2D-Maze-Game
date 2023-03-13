package com.example.abstractfactory;
import com.example.game.GameEngine;
import com.example.game.LevelOne;

public class MapAbstractFactory implements GameLevelFactory{
  GameObjectFactory gameObjectFactory;
  GameEngine gameBarrier = new GameEngine(gameObjectFactory);
  @Override
  public LevelOne createLevelOne() {
    return new LevelOne(gameBarrier);
  }
  
  // @Override
  // public LevelTwo createLevelTwo() {
  //   return new LevelTwo();
  // }
  // 
  // @Override
  // public LevelThree createLevelThree() {
  //   return new LevelThree();
  // }
}
