package com.example.menu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.metal.MetalButtonUI;


public class MainMenu extends JFrame implements ActionListener {

    // buttons
    JButton playButton, howToPlayButton, exitButton;

    // constructor
    public MainMenu() {
        // set the title
        setTitle("SFU Escape");

        // set the background color of the JFrame
        getContentPane().setBackground(new Color(204, 6, 51));

        // create the buttons
        playButton = new JButton("Play");
        howToPlayButton = new JButton("How to Play");
        exitButton = new JButton("Exit");

        // set the preferred size of the buttons
        playButton.setUI(new MetalButtonUI());
        playButton.setPreferredSize(new Dimension(100, 50));
        playButton.setBackground(new Color(166, 25, 46));
        playButton.setForeground(Color.WHITE);

        howToPlayButton.setUI(new MetalButtonUI());
        howToPlayButton.setPreferredSize(new Dimension(130, 50));
        howToPlayButton.setBackground(new Color(166, 25, 46));
        howToPlayButton.setForeground(Color.WHITE);

        exitButton.setUI(new MetalButtonUI());
        exitButton.setPreferredSize(new Dimension(100, 50));
        exitButton.setBackground(new Color(166, 25, 46));
        exitButton.setForeground(Color.WHITE);

        playButton.setFocusPainted(false);
        howToPlayButton.setFocusPainted(false);
        exitButton.setFocusPainted(false);

        // add action listeners to the buttons
        playButton.addActionListener(this);
        howToPlayButton.addActionListener(this);
        exitButton.addActionListener(this);

        // create the panel for the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 65, 20)); // set the layout manager to FlowLayout and center the buttons
        buttonPanel.setBackground(new Color(204, 6, 51));
        JLabel header = new JLabel("SFU Break");
        header.setFont(new Font("Arial", Font.BOLD, 50));
        header.setForeground(Color.WHITE);
        header.setAlignmentX(Component.CENTER_ALIGNMENT); // center the header horizontally
        header.setHorizontalAlignment(SwingConstants.CENTER); // center the header text
        buttonPanel.add(playButton);
        buttonPanel.add(howToPlayButton);
        buttonPanel.add(exitButton);

        // add the panel to the frame
        Box container = Box.createVerticalBox(); // create a vertical box container
        container.setBorder(new EmptyBorder(75, 50, 0, 50)); // add a top margin to the container
        container.setBackground(new Color(204, 6, 51));
        container.add(header);
        container.add(Box.createVerticalStrut(110)); // add a vertical gap between the header and the buttons
        container.add(buttonPanel);
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
            ChooseDifficulty chooseDifficulty = new ChooseDifficulty();
            chooseDifficulty.setVisible(true);
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



