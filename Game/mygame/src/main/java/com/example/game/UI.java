package com.example.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {
  GameEngine gameBarrier;
  Font times_new_roman_40, times_new_roman_100;
  public boolean gameOver = false;

  public UI(GameEngine gameEngine) {
    this.gameBarrier = gameEngine;
    times_new_roman_40 = new Font("Times New Roman", Font.PLAIN, 40);
    times_new_roman_100 = new Font("Times New Roman", Font.PLAIN, 100);
  }

  public void draw(Graphics2D g) {
    g.setFont(times_new_roman_40);
    g.setColor(Color.WHITE);
    g.drawString("Score: " + gameBarrier.mainChar.getScore(), 50, 50);
    g.drawString("Time: " + gameBarrier.gameTime / 1000 + "s", 50, 100);
    if (gameOver == true) {
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, gameBarrier.screenWidth, gameBarrier.screenHeight);

      g.setFont(times_new_roman_100);
      g.setColor(Color.WHITE);
      String text, scoreText, timeText;
      int textLength, textLength2, textLength3;
      text = "Game Over";
      scoreText = "Score: " + gameBarrier.mainChar.getScore();
      timeText = "Time: " + gameBarrier.gameTime / 1000 + "s";
      textLength = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
      int x = gameBarrier.screenWidth / 2 - textLength / 2;
      int y = gameBarrier.screenHeight / 2 - textLength / 2;

      g.drawString(text, x, y);
      g.setFont(times_new_roman_40);
      textLength2 = (int) g.getFontMetrics().getStringBounds(scoreText, g).getWidth();
      textLength3 = (int) g.getFontMetrics().getStringBounds(timeText, g).getWidth();
      int xText = gameBarrier.screenWidth / 2 - textLength2 / 2;
      int yText = gameBarrier.screenHeight / 2 - textLength2 / 2;
      int xTime = gameBarrier.screenWidth / 2 - textLength3 / 2;
      int yTime = gameBarrier.screenHeight / 2 - textLength3 / 2;
      g.drawString(scoreText, xText, yText - 70);
      g.drawString(timeText, xTime, yTime - 10);
      gameBarrier.gameThread = null;
    }
  }

}
