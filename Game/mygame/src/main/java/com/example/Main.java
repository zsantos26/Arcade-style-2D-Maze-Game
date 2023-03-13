package com.example;

import javax.swing.JFrame;

import com.example.abstractfactory.AbstractFactory;
import com.example.abstractfactory.GameObjectFactory;
import com.example.game.GameEngine;
import com.example.menu.ChooseDifficulty;

public class Main {
  public static void main(String[] args) {
    GameObjectFactory gameObjectFactory = new AbstractFactory();
    ChooseDifficulty chooseDifficulty = new ChooseDifficulty();
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle("SFU Escape");

    GameEngine gameEngine = new GameEngine(gameObjectFactory);
    window.add(gameEngine);

    window.pack();

    window.setLocationRelativeTo(null);
    window.setVisible(true);

    gameEngine.startGameThread();
  }
}
