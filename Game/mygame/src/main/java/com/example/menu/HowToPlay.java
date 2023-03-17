package com.example.menu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.metal.MetalButtonUI;

public class HowToPlay extends JFrame implements ActionListener {

    // buttons
    JButton backButton;

    // constructor
    public HowToPlay() {
        // set the title
        setTitle("How to Play");

        // set the background color of the JFrame
        getContentPane().setBackground(new Color(204, 6, 51));

        // create the back button
        backButton = new JButton("Back");

        // set the preferred size of the button
        backButton.setUI(new MetalButtonUI());
        backButton.setPreferredSize(new Dimension(100, 50));
        backButton.setBackground(new Color(166, 25, 46));
        backButton.setForeground(Color.WHITE);

        backButton.setFocusPainted(false);

        // add action listeners to the button
        backButton.addActionListener(this);

        // create the panel for the back button
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        backPanel.setBackground(new Color(204, 6, 51));
        backPanel.setPreferredSize(new Dimension(100, 90));
        backPanel.add(backButton);

        // create the panel for the header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(204, 6, 51));
        headerPanel.setPreferredSize(new Dimension(500, 70));
        headerPanel.setMinimumSize(new Dimension(500, 70));
        JLabel header = new JLabel("How to Play");
        header.setFont(new Font("Arial", Font.BOLD, 50));
        header.setForeground(Color.WHITE);
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(header);

        // create the text area for the instructions on the left
        JTextArea instructionsLeft = new JTextArea();
        instructionsLeft.setBackground(new Color(204, 6, 51));
        instructionsLeft.setForeground(Color.WHITE);
        instructionsLeft.setFont(new Font("Arial", Font.BOLD, 14));
        instructionsLeft.setText("Objective of the Game:\n" +
                "\u25CF  You control a Student enrolled at SFU\n" +
                "\u25CF  Collect all Textbooks\n" +
                "\u25CF  Diplomas are a bonus\n" +
                "\u25CF  Security cameras deduct points\n" +
                "\u25CF  If your points fall negative, you lose!\n" +
                "\u25CF  If a warm-blooded Raccoon catches you,\n" +
                "    you lose!\n" +
                "\u25CF  Escape the Campus with all Textbooks \n" +
                "    in your hand!");
        instructionsLeft.setMaximumSize(new Dimension(350, 200));
        instructionsLeft.setMinimumSize(new Dimension(250, 55));
        instructionsLeft.setPreferredSize(new Dimension(250, 180));
        

       // create the blank panel
        JPanel blankPanel = new JPanel();
        blankPanel.setPreferredSize(new Dimension(65, 50));
        blankPanel.setMaximumSize(new Dimension(90, 50));
        blankPanel.setMinimumSize(new Dimension(35, 50));
        blankPanel.setBackground(new Color(204, 6, 51));


        // create the text area for the instructions on the right
        JTextArea instructionsRight = new JTextArea();
        instructionsRight.setBackground(new Color(204, 6, 51));
        instructionsRight.setForeground(Color.WHITE);
        instructionsRight.setFont(new Font("Arial", Font.BOLD, 15));
        instructionsRight.setText("Controls:\n\n" +
                "    Movement\t          -         Key\n\n" +
                "      Move Up\t\t↑\n" +
                "      Move Left\t\t←\n" +
                "      Move Right\t\t→\n" +
                "      Move Down\t↓\n");
        instructionsRight.setMaximumSize(new Dimension(350, 200));
        instructionsRight.setPreferredSize(new Dimension(125, 100));


        // create the panel for the text areas and the back button
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(204, 6, 51));
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
        contentPanel.add(Box.createHorizontalStrut(8));
        contentPanel.add(instructionsLeft);
        contentPanel.add(Box.createHorizontalStrut(0));
        contentPanel.add(blankPanel);
        contentPanel.add(instructionsRight);
        contentPanel.add(Box.createHorizontalStrut(4));
        

        // add the panels and back button to the frame
        Box container = Box.createVerticalBox(); // create a vertical box container
        container.setBorder(new EmptyBorder(30, 15, 0, 15)); // add a top margin to the container
        container.setBackground(new Color(204, 6, 51));
        container.add(headerPanel);
        container.add(Box.createVerticalStrut(4)); // add a vertical gap between the header and the instructions
        container.add(contentPanel);
        container.add(Box.createVerticalStrut(0)); // add a vertical gap between the instructions and the back button
        container.add(backPanel);

        add(container);

        // set the size and center the frame
        setSize(1280, 720);
        setMinimumSize(new Dimension(640, 360)); // set the minimum size of the window
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // button actions
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
            dispose();
        }
    }

    // main method to run the game
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
    }
}

