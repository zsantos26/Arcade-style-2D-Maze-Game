package com.example.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {
  GameEngine gameBarrier;
  Font times_new_roman_40;

  public UI(GameEngine gameEngine) {
    this.gameBarrier = gameEngine;
    times_new_roman_40 = new Font("Times New Roman", Font.PLAIN, 40);
  }

  public void draw(Graphics2D g) {
    g.setFont(times_new_roman_40);
    g.setColor(Color.WHITE);
    g.drawString("Score: " + gameBarrier.mainChar.getScore(), 50, 50);
  }

}
