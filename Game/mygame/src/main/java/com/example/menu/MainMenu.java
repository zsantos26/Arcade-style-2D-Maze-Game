package com.example.menu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.metal.MetalButtonUI;


public class MainMenu extends JFrame implements ActionListener {

    // Declare 3 JButton to represent 3 buttons to appear on screen
    JButton playButton, howToPlayButton, exitButton;

    // Constructor
    public MainMenu() {
        // Set title
        setTitle("SFU Escape");

        // Set the background colour of the JFrame to SFU Primary colours
        getContentPane().setBackground(new Color(204, 6, 51));

        // Initialize buttons with representative text
        playButton = new JButton("Play");
        howToPlayButton = new JButton("How to Play");
        exitButton = new JButton("Exit");

        // Set the colour and UI of the buttons, aswell as the preferred size of the buttons
        playButton.setUI(new MetalButtonUI());
        playButton.setPreferredSize(new Dimension(100, 50));
        playButton.setBackground(new Color(166, 25, 46));  // Set the background colour to SFU secondary colour
        playButton.setForeground(Color.WHITE);
        playButton.setFocusPainted(false);  // When a button is selected (but not clicked), disables visual cue

        howToPlayButton.setUI(new MetalButtonUI());
        howToPlayButton.setPreferredSize(new Dimension(130, 50));
        howToPlayButton.setBackground(new Color(166, 25, 46));  // Set the background colour to SFU secondary colour
        howToPlayButton.setForeground(Color.WHITE);
        howToPlayButton.setFocusPainted(false);  // When a button is selected (but not clicked), disables visual cue

        exitButton.setUI(new MetalButtonUI());
        exitButton.setPreferredSize(new Dimension(100, 50));  // Set the background colour to SFU secondary colour
        exitButton.setBackground(new Color(166, 25, 46));
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusPainted(false);  // When a button is selected (but not clicked), disables visual cue

        // Add action listeners. Allows for program to respond to button clicks.
        playButton.addActionListener(this);
        howToPlayButton.addActionListener(this);
        exitButton.addActionListener(this);

        // Create the buttonPanel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 65, 20)); // Set the layout manager to FlowLayout and center the buttons
        buttonPanel.setBackground(new Color(204, 6, 51));  // Set to match background colours
        JLabel header = new JLabel("SFU Break");
        header.setFont(new Font("Arial", Font.BOLD, 50));
        header.setForeground(Color.WHITE);
        header.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the header horizontally
        header.setHorizontalAlignment(SwingConstants.CENTER); // Center the header text
        // Add buttons to panel
        buttonPanel.add(playButton);
        buttonPanel.add(howToPlayButton);
        buttonPanel.add(exitButton);

        // Add the panel to the frame
        Box container = Box.createVerticalBox(); // create a vertical box container
        container.setBorder(new EmptyBorder(75, 50, 0, 50)); // Add top, left and right margins to the container
        container.setBackground(new Color(204, 6, 51));
        container.add(header);  // Add header
        container.add(Box.createVerticalStrut(110)); // Add vertical gap between the header and the buttons
        container.add(buttonPanel);
        add(container);

        // Set the initial. and minimum, size of the frame
        setSize(1280, 720);
        setMinimumSize(new Dimension(640, 360)); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    // button actions
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            PlayScreen playScreen = new PlayScreen();
            playScreen.setVisible(true);
            dispose();
        } else if (e.getSource() == howToPlayButton) {
            HowToPlay howToPlay = new HowToPlay();
            howToPlay.setVisible(true);
            dispose();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

}
