package com.example.mygame.view;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    
    private JPanel gamePanel;
    private JButton startButton;
    private JButton exitButton;
    private JLabel scoreLabel;
    
    public GameView() {
        // Set up the main window
        setTitle("My Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        // Create the game panel
        gamePanel = new JPanel();
        gamePanel.setBackground(Color.BLACK);
        
        // Create the start and exit buttons
        startButton = new JButton("Start Game");
        exitButton = new JButton("Exit Game");
        
        // Create the score label
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(Color.WHITE);
        
        // Add the components to the main window
        add(gamePanel, BorderLayout.CENTER);
        add(startButton, BorderLayout.NORTH);
        add(exitButton, BorderLayout.SOUTH);
        add(scoreLabel, BorderLayout.EAST);
        
        // Show the main window
        setVisible(true);
    }
    
    public static void main(String[] args) {
        // Create a new GameWorld object
        new GameView();
    }
}
