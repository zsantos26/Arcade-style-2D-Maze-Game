package com.example.menu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.metal.MetalButtonUI;
import com.example.game.GameEngine;
import com.example.abstractfactory.AbstractFactory;
import com.example.abstractfactory.GameObjectFactory;

public class ChooseDifficulty extends JFrame implements ActionListener {

    // Decalre type JButton variables for the ChooseDifficulty screen
    JButton easyButton, mediumButton, hardButton, backButton;

    // constructor
    public ChooseDifficulty() {
        // set the title
        setTitle("Choose Difficulty");

        // getContentPane() returns ContentPane. setBackground() changes the colour of the ContentPane to the primary SFU Colours
        getContentPane().setBackground(new Color(204, 6, 51));

        // Create header panel for header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(new Color(204, 6, 51));  // Set background colour to match content pane background panel
        // Create header text and set visuals
        JLabel headerLabel = new JLabel("Choose Difficulty");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 50));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        headerPanel.setMinimumSize(new Dimension(Integer.MAX_VALUE, 70));


        // Create 4 JButton objects. Assign these to the 4 variables declared earlier.
        easyButton = new JButton("Easy");
        mediumButton = new JButton("Medium");
        hardButton = new JButton("Hard");
        backButton = new JButton("Back");

        // Set visuals for the difficulty buttons. Background colours correspond to SFU secondary colours. Text (foreground) colours correspond to SFU white. Also, add Action Listening to buttons. Allows button to detect user input 
        easyButton.setUI(new MetalButtonUI());
        easyButton.setPreferredSize(new Dimension(130, 50));
        easyButton.setBackground(new Color(166, 25, 46));
        easyButton.setForeground(Color.WHITE);
        easyButton.setFocusPainted(false);  // Set focus painted quality to false so if selected, button border is not highlighted
        easyButton.addActionListener(this);

        mediumButton.setUI(new MetalButtonUI());
        mediumButton.setPreferredSize(new Dimension(130, 50));
        mediumButton.setBackground(new Color(166, 25, 46));
        mediumButton.setForeground(Color.WHITE);
        mediumButton.setFocusPainted(false);  // Set focus painted quality to false so if selected, button border is not highlighted
        mediumButton.addActionListener(this);

        hardButton.setUI(new MetalButtonUI());
        hardButton.setPreferredSize(new Dimension(130, 50));
        hardButton.setBackground(new Color(166, 25, 46));
        hardButton.setForeground(Color.WHITE);
        hardButton.setFocusPainted(false);  // Set focus painted quality to false so if selected, button border is not highlighted
        hardButton.addActionListener(this);

        // Set visuals for the back button.Background colours correspond to SFU secondary colours. Text (foreground) colours correspond to SFU white. 
        backButton.setPreferredSize(new Dimension(100, 50));
        backButton.setBackground(new Color(166, 25, 46));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);  // Set focus painted quality to false so if selected, button border is not highlighted
        backButton.addActionListener(this); // Add Action Listening to button. Allows button to detect user input 

        // Create the button panel for the difficulty buttons.
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 65, 10)); // Use FlowLayout and center buttons
        buttonPanel.setBackground(new Color(204, 6, 51));  // Set buttonPanel background to match contentPanel background colours
        // Add difficulty buttons to buttonPanel
        buttonPanel.add(easyButton);
        buttonPanel.add(mediumButton);
        buttonPanel.add(hardButton);
        buttonPanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, 60));

        // Create the button panel for the back button and add back button to panel.
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        backPanel.setBackground(new Color(204, 6, 51));  // Sett backPanel background to match content panel backround colours
        backPanel.add(backButton);

        // Create container and add. Add the header, difficulty button and back button panels to container
        Box container = Box.createVerticalBox(); // create a vertical box container
        container.setBorder(new EmptyBorder(30, 20, 5, 20)); // Add borders for the container.
        container.setBackground(new Color(204, 6, 51));  // Set background to match ContentPanel colours
        container.add(headerPanel);
        container.add(Box.createVerticalStrut(30)); // Add a vertical gap to seperate header and difficulty buttons
        container.add(buttonPanel);
        container.add(backPanel);
        container.setPreferredSize(new Dimension(Integer.MAX_VALUE, 190));
        add(container);  // Add container to JFrame

        // Set size of frame and center
        setSize(1280, 720);
        setMinimumSize(new Dimension(640, 360)); // Set minimum size to avoid visual issues
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Set reactions correspinding to buttons on the screen
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
