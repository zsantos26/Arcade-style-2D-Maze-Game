package com.example.game;
import java.awt.Graphics2D;

public class GameWorld {
  GameEngine gameBarrier;
  LevelOne levelOne;
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
    levelOne.draw(g2d, cellSize);
  }
}