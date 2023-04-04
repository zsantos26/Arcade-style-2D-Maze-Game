package com.example.menu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
/**
 * The MainMenu class represents the first screen displayed for the game. 
 * 
 * The class extends the JFrame class and implements the ActionListener to respond to user interactions with the buttons.
 * It puts three buttons on display. The play button leads to a screen to let the user start the game.
 * The 'How To Play' lets the user learn the objectives, controls and additional information about the game.
 * The exit button closes the program.
 */

public class MainMenu extends JFrame implements ActionListener {

    private static final Color PRIMARY_COLOR = new Color(204, 6, 51);

    // Declare 3 JButton instances to represent interactable buttons on the screen
    JButton playButton, howToPlayButton, exitButton;

    /**
     * Constructor for the MainMenu class
     * 
     * Sets the title of the JFrame and initializes the text to correspond the the actions if clicked.
     * Sets the color and user interface for the buttons to correspond to SFU colours.
     * Adds action listeners to the buttons.
     * Creates a JPanel to hold the buttons and adds it to the screen.
     * Sets the initial and minimum size of the frame, centers it, and sets the default close operation.
     */
    public MainMenu() {

        // Set title
        setTitle("SFU Escape");

        // Set the background colour of the JFrame to SFU Primary colours
        getContentPane().setBackground(PRIMARY_COLOR);

        // Initialize buttons with representative text
        playButton = new JButton("Play");
        howToPlayButton = new JButton("How to Play");
        exitButton = new JButton("Exit");

        // Use ButtonStyler to style buttons
        ButtonStyler.styleButton(playButton, 100, 50, 14);
        ButtonStyler.styleButton(howToPlayButton, 130, 50, 14);
        ButtonStyler.styleButton(exitButton, 100, 50, 14);

        // Add action listeners. Allows for program to respond to button clicks.
        playButton.addActionListener(this);
        howToPlayButton.addActionListener(this);
        exitButton.addActionListener(this);

        // Create the buttonPanel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 65, 20)); // Set the layout manager to FlowLayout and center the buttons
        buttonPanel.setBackground(PRIMARY_COLOR);  // Set to match background colours
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
        container.setBackground(PRIMARY_COLOR);
        container.add(header);  // Add header
        container.add(Box.createVerticalStrut(110)); // Add vertical gap between the header and the buttons
        container.add(buttonPanel);
        add(container);

        // Set the initial. and minimum, size of the frame
        setSize(1280, 720);
        setMinimumSize(new Dimension(640, 360));  // Prevent UI structure from breaking down
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * ActionPerformed method. This responds to the buttons interacted with by the user.
     * 
     * This method gets called when the user clicks one of the buttons, either 'Play', 'How to Play', or 'Exit'.
     * If the button clicked is 'Play', a PlayScreen object is created and current frame gets disposed
     * If the button clicked is 'How to Play', HowToPlay object is created  and current frame gets disposed
     * If the button clicked is 'Exit', program closes.
     * 
     * @param e The ActionEvent object that carries information regarding how the button has been interacted with
     */
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
