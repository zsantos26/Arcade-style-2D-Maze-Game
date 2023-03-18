package com.example.game;

import java.awt.Graphics2D;

public class LevelOneGameWorld extends GameWorld {
  private LevelOne levelOne;

  public LevelOneGameWorld(GameEngine gameEngine) {
    super(gameEngine);
    this.levelOne = new LevelOne(gameEngine);
  }

  @Override
  public void getCellImage() {
    levelOne.getCellImage();
  }

  @Override
  public void drawMap(String filePath, int map) {
    levelOne.drawMap(filePath, map);
  }

  @Override
  public void draw(Graphics2D g2d, int cellSize) {
    levelOne.draw(g2d, cellSize);
  }
}
