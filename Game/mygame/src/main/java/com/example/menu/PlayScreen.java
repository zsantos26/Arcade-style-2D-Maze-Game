package com.example.menu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.metal.MetalButtonUI;

public class PlayScreen extends JFrame implements ActionListener {

    // buttons
    JButton playButton, backButton;

    // constructor
    public PlayScreen() {
        // set the title
        setTitle("Play");

        // set the background color of the JFrame
        getContentPane().setBackground(new Color(204, 6, 51));

        // create the buttons
        playButton = new JButton("Start Game");
        backButton = new JButton("Back");

        // set the preferred size of the buttons
        playButton.setUI(new MetalButtonUI());
        playButton.setPreferredSize(new Dimension(200, 75));
        playButton.setBackground(new Color(166, 25, 46));
        playButton.setForeground(Color.WHITE);
        playButton.setFont(new Font(null, Font.PLAIN, 24));

        backButton.setUI(new MetalButtonUI());
        backButton.setPreferredSize(new Dimension(100, 50));
        backButton.setBackground(new Color(166, 25, 46));
        backButton.setForeground(Color.WHITE);

        playButton.setFocusPainted(false);
        backButton.setFocusPainted(false);

        // add action listeners to the buttons
        playButton.addActionListener(this);
        backButton.addActionListener(this);

        // create the panel for the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 65, 10)); // set the layout manager to FlowLayout and center the buttons
        buttonPanel.setBackground(new Color(204, 6, 51));
        buttonPanel.add(playButton);
        buttonPanel.setMinimumSize(new Dimension(Integer.MAX_VALUE, 100));
        buttonPanel.setPreferredSize(new Dimension(Integer.MAX_VALUE,100));
        
        // create the panel for the back button
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        backPanel.setBackground(new Color(204, 6, 51));
        backPanel.add(backButton);
        backPanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, 500));

        // create the panel for the header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(new Color(204, 6, 51));
        JLabel headerLabel = new JLabel("Play");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 50));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        headerPanel.setMinimumSize(new Dimension(200, 70));
        headerPanel.setPreferredSize(new Dimension(200, 300));
        
        // add the panels to the frame
        Box container = Box.createVerticalBox(); // create a vertical box container
        container.setBorder(new EmptyBorder(30, 0, 5, 0)); // add a top margin to the container
        container.setBackground(new Color(204, 6, 51));
        container.add(headerPanel);
        container.add(Box.createVerticalStrut(30)); // add a vertical gap between the header and the buttons
        container.add(buttonPanel);
        container.add(backPanel);
        container.setPreferredSize(new Dimension(Integer.MAX_VALUE, 260));
        add(container);

        // set the size and center the frame
        setSize(1280, 720);
        setMinimumSize(new Dimension(640, 360)); // set the minimum size of the window
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // button actions
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            JOptionPane.showMessageDialog(null, "The game is starting.");
            // TODO: Start the game
        } else if (e.getSource() == backButton) {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
            dispose();
        }
    }

   
}
