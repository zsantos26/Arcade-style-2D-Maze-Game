package com.example.game;
import java.awt.Graphics2D;

public class GameWorld {
  GameEngine gameBarrier;
  LevelOne levelOne;
  LevelTwo levelTwo;
  Cells[] cell;
  public int mapCells [][];

  public GameWorld(GameEngine gameEngine) {
    this.gameBarrier = gameEngine;
    this.levelOne = new LevelOne(gameEngine);
  }

  public void getCellImage(){
    try{
      levelOne.getCellImage();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void drawMap(String filePath){
    try{
      levelOne.drawMap(filePath);
    } catch(Exception e){
      e.printStackTrace();
    }
  }
  public void draw(Graphics2D g2d, int cellSize) {
    //TO DO: Need to implement if condition for transitioning from levelOne to levelTwo and so on
    //We also need to keep in mind that user could just select difficulties from the MainMenu so
    //We could just create a switch case that takes in an input from MainMenu click?
    //OR we could make it so that when levelOne is completed we proceed to the next one?
    //We need to choose one method
    levelOne.draw(g2d, cellSize);
  }
}