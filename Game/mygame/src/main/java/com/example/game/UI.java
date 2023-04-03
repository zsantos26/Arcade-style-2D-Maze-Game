package com.example.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {
  GameEngine gameBarrier;
  Font times_new_roman_40, times_new_roman_100;
  public boolean gameOver = false;
  public boolean victory = false;

  public UI(GameEngine gameEngine) {
    this.gameBarrier = gameEngine;
    times_new_roman_40 = new Font("Times New Roman", Font.PLAIN, 40);
    times_new_roman_100 = new Font("Times New Roman", Font.PLAIN, 100);
  }

  public void draw(Graphics2D g) {
    Font titleFont = new Font("Times New Roman", Font.BOLD, 100);
    Font infoFont = new Font("Times New Roman", Font.PLAIN, 40);

    // Draw score and time info at the top of the screen
    g.setFont(infoFont);
    g.setColor(Color.WHITE);
    g.drawString("Score: " + gameBarrier.mainChar.getScore(), 50, 50);
    g.drawString("Time: " + gameBarrier.gameTime / 1000 + "s", 50, 100);

    // Draw victory screen if game is won
    if (victory) {
      drawEndScreen(g, "You Win!", Color.YELLOW, titleFont);
    }

    // Draw game over screen if game is lost
    if (gameOver) {
      drawEndScreen(g, "Game Over", Color.WHITE, titleFont);
    }
  }

  // Helper method to draw the end game screen
  private void drawEndScreen(Graphics2D g, String title, Color color, Font titleFont) {
    // Fill the screen with black
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, gameBarrier.screenWidth, gameBarrier.screenHeight);

    // Draw the title in the center of the screen
    g.setFont(titleFont);
    g.setColor(color);
    int titleWidth = g.getFontMetrics().stringWidth(title);
    int titleX = (gameBarrier.screenWidth - titleWidth) / 2;
    int titleY = gameBarrier.screenHeight / 2 - 50;
    g.drawString(title, titleX, titleY);

    // Draw the score and time info below the title
    g.setFont(new Font("Times New Roman", Font.PLAIN, 40));
    String scoreText = "Score: " + gameBarrier.mainChar.getScore();
    String timeText = "Time: " + gameBarrier.gameTime / 1000 + "s";
    int infoWidth = Math.max(g.getFontMetrics().stringWidth(scoreText), g.getFontMetrics().stringWidth(timeText));
    int infoX = (gameBarrier.screenWidth - infoWidth) / 2;
    int infoY = titleY + 100;
    g.setColor(Color.WHITE);
    g.drawString(scoreText, infoX, infoY);
    g.drawString(timeText, infoX, infoY + 50);

    // Set the game thread to null to stop the game loop
    gameBarrier.gameThread = null;
  }
}
