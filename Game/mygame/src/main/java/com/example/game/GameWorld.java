package com.example.game;

import java.awt.Graphics2D;

public class GameWorld {
  GameEngine gameBarrier;
  private LevelOne levelOne;
  Cells[] cell;
  public int mapCells[][][];

  public GameWorld(GameEngine gameEngine) {
    this.gameBarrier = gameEngine;
    this.levelOne = new LevelOne(gameBarrier);
    cell = new Cells[70];
    mapCells = new int[gameBarrier.maxMap][gameBarrier.maxScreenCol][gameBarrier.maxScreenRow];
    drawMap("/maps/Map_AQ.txt", 0);
    drawMap("/maps/Map_Class.txt", 1);
    getCellImage();
  }

  public void getCellImage() {
    levelOne.getCellImage();
  }

  public void drawMap(String filePath, int map) {
    levelOne.drawMap(filePath, map);
  }

  public void draw(Graphics2D g2d, int cellSize) {
    levelOne.draw(g2d, cellSize);
  }
}