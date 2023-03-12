package com.example.abstractfactory;

import com.example.game.LevelOne;

public class MapAbstractFactory implements GameLevelFactory{
  @Override
  public LevelOne createLevelOne() {
    return new LevelOne();
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
