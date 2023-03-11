package com.example;

import javax.swing.JFrame;

import com.example.game.GameEngine;

public class Main {
  public static void main(String[] args) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle("SFU Escape");

    GameEngine gameEngine = new GameEngine();
    window.add(gameEngine);

    window.pack();

    window.setLocationRelativeTo(null);
    window.setVisible(true);

    gameEngine.startGameThread();
  }
}
