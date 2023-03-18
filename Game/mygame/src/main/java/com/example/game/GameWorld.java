package com.example.game;

import java.awt.Graphics2D;

public abstract class GameWorld {
  GameEngine gameBarrier;
  Cells[] cell;
  public int mapCells[][][];

  public GameWorld(GameEngine gameEngine) {
    this.gameBarrier = gameEngine;
    cell = new Cells[70];
    mapCells = new int[gameBarrier.maxMap][gameBarrier.maxScreenCol][gameBarrier.maxScreenRow];
  }

  public abstract void getCellImage();

  public abstract void drawMap(String filePath, int map);

  public abstract void draw(Graphics2D g2d, int cellSize);
}
