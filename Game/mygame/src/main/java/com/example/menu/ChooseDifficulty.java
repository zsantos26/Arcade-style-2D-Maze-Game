package com.example.menu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.metal.MetalButtonUI;
import com.example.abstractfactory.AbstractFactory;
import com.example.abstractfactory.GameObjectFactory;
import com.example.game.GameEngine;

public class ChooseDifficulty extends JFrame implements ActionListener {

    // buttons
    JButton easyButton, mediumButton, hardButton, backButton;

    // constructor
    public ChooseDifficulty() {
        // set the title
        setTitle("Choose Difficulty");

        // set the background color of the JFrame
        getContentPane().setBackground(new Color(204, 6, 51));

        // create the buttons
        easyButton = new JButton("Easy");
        mediumButton = new JButton("Medium");
        hardButton = new JButton("Hard");
        backButton = new JButton("Back");

        // set the preferred size of the buttons
        easyButton.setUI(new MetalButtonUI());
        easyButton.setPreferredSize(new Dimension(130, 50));
        easyButton.setBackground(new Color(166, 25, 46));
        easyButton.setForeground(Color.WHITE);

        mediumButton.setUI(new MetalButtonUI());
        mediumButton.setPreferredSize(new Dimension(130, 50));
        mediumButton.setBackground(new Color(166, 25, 46));
        mediumButton.setForeground(Color.WHITE);

        hardButton.setUI(new MetalButtonUI());
        hardButton.setPreferredSize(new Dimension(130, 50));
        hardButton.setBackground(new Color(166, 25, 46));
        hardButton.setForeground(Color.WHITE);

        backButton.setUI(new MetalButtonUI());
        backButton.setPreferredSize(new Dimension(100, 50));
        backButton.setBackground(new Color(166, 25, 46));
        backButton.setForeground(Color.WHITE);

        easyButton.setFocusPainted(false);
        mediumButton.setFocusPainted(false);
        hardButton.setFocusPainted(false);
        backButton.setFocusPainted(false);

        // add action listeners to the buttons
        easyButton.addActionListener(this);
        mediumButton.addActionListener(this);
        hardButton.addActionListener(this);
        backButton.addActionListener(this);

        // create the panel for the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 65, 10)); // set the layout manager to FlowLayout and center the buttons
        buttonPanel.setBackground(new Color(204, 6, 51));
        buttonPanel.add(easyButton);
        buttonPanel.add(mediumButton);
        buttonPanel.add(hardButton);
        buttonPanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, 60));
        
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        backPanel.setBackground(new Color(204, 6, 51));
        backPanel.add(backButton);

        // create the panel for the header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(new Color(204, 6, 51));
        JLabel headerLabel = new JLabel("Choose Difficulty");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 50));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        headerPanel.setMinimumSize(new Dimension(Integer.MAX_VALUE, 70));
        
        // add the panels to the frame
        Box container = Box.createVerticalBox(); // create a vertical box container
        container.setBorder(new EmptyBorder(30, 20, 5, 20)); // add a top margin to the container
        container.setBackground(new Color(204, 6, 51));
        container.add(headerPanel);
        container.add(Box.createVerticalStrut(30)); // add a vertical gap between the header and the buttons
        container.add(buttonPanel);
        container.add(backPanel);
        container.setPreferredSize(new Dimension(Integer.MAX_VALUE, 190));
        add(container);

        // set the size and center the frame
        setSize(1280, 720);
        setMinimumSize(new Dimension(640, 360)); // set the minimum size of the window
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // button actions
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == easyButton) {
            JOptionPane.showMessageDialog(null, "You chose easy difficulty.");
            GameObjectFactory gameObjectFactory = new AbstractFactory();
            GameEngine gameEngine = new GameEngine(gameObjectFactory);
            gameEngine.startGameThread();
        } else if (e.getSource() == mediumButton) {
            JOptionPane.showMessageDialog(null, "You chose medium difficulty.");
            GameObjectFactory gameObjectFactory = new AbstractFactory();
            GameEngine gameEngine = new GameEngine(gameObjectFactory);
            gameEngine.startGameThread();
        } else if (e.getSource() == hardButton) {
            JOptionPane.showMessageDialog(null, "You chose hard difficulty.");
            GameObjectFactory gameObjectFactory = new AbstractFactory();
            GameEngine gameEngine = new GameEngine(gameObjectFactory);
            gameEngine.startGameThread();
        } else if (e.getSource() == backButton) {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
            dispose();
        }
    }

}
