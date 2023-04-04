package com.example.menu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * The HowToPlay class represents the screen that displays the objectives of the game the controls, and additional information.
 * 
 * The class extends the JFrame class and implements the ActionListener to respond to user interactions with the button.
 * The class makes a back button and adds an action listener to it.
 * The class also creates panels to hold the header, instructions, and back button, and adds them to the frame.
 * When the "Back" button is clicked, it creates a MainMenu object and disposes of the current frame.
 * The user then returns to the main menu.
 * 
 * The buttons are styled using ButtonStyler class to represent SFU colours
 */
public class HowToPlay extends JFrame implements ActionListener {

    // Constant to represent SFU primary colours
    private static final Color PRIMARY_COLOR = new Color(204, 6, 51);

     // Declare JButton instances to represent interactable buttons back button that returns user to MainMenu screen.
    JButton backButton;

    /**
     * Constructs a HowToPlay object.
     * 
     * Sets the title of the JFrame and sets the background colour (SFU colours) of the frame.
     * Creates a back button with sizing and an action listener.
     * Creates panels to hold the header, instructions, and back button, and adds them to the frame.
     * Sets the size, minimum size, and centers the frame. Also adds the default close operation.
     */
    public HowToPlay() {

        // set the title
        setTitle("How to Play");

        // set the background color of the JFrame to match SFU primary colours
        getContentPane().setBackground(PRIMARY_COLOR);

        // create the back button
        backButton = new JButton("Back");

        // set the button style
        ButtonStyler.styleButton(backButton, 100, 50, 16);

        // add action listeners to the button
        backButton.addActionListener(this);

        // create the panel for the back button
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        backPanel.setBackground(PRIMARY_COLOR);
        backPanel.setPreferredSize(new Dimension(100, 90));
        backPanel.add(backButton);

        // create the panel for the header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(PRIMARY_COLOR);
        headerPanel.setPreferredSize(new Dimension(500, 70));
        headerPanel.setMinimumSize(new Dimension(500, 70));  // Prevent UI structure from breaking down
        JLabel header = new JLabel("How to Play");
        header.setFont(new Font("Arial", Font.BOLD, 50));
        header.setForeground(Color.WHITE);
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(header);

        // create the text area for the objective Instructions
        JTextArea objectiveInstructions = new JTextArea();
        objectiveInstructions.setBackground(PRIMARY_COLOR);
        objectiveInstructions.setForeground(Color.WHITE);
        objectiveInstructions.setFont(new Font("Arial", Font.BOLD, 14));
        objectiveInstructions.setText("Objective of the Game:\n" +
                "\u25CF  You control a Student enrolled at SFU\n" +
                "\u25CF  Collect all Textbooks\n" +
                "\u25CF  Diplomas are a bonus\n" +
                "\u25CF  Security cameras deduct points\n" +
                "\u25CF  If your points fall negative, you lose!\n" +
                "\u25CF  If a warm-blooded Raccoon catches you,\n" +
                "    you lose!\n" +
                "\u25CF  Escape the Campus with all Textbooks \n" +
                "    in your hand!");
        objectiveInstructions.setMaximumSize(new Dimension(350, 200));
        objectiveInstructions.setMinimumSize(new Dimension(250, 55));  // Prevent UI structure from breaking down
        objectiveInstructions.setPreferredSize(new Dimension(250, 180));
        

       // Create the blank panel. This is to help with screen spacing and aesthetics. 
        JPanel blankPanel = new JPanel();
        blankPanel.setPreferredSize(new Dimension(65, 50));
        blankPanel.setMaximumSize(new Dimension(90, 50));
        blankPanel.setMinimumSize(new Dimension(35, 50));  // Prevent UI structure from breaking down
        blankPanel.setBackground(PRIMARY_COLOR);  // Colours match background of frame.


        // create the text area contro lInstructions
        JTextArea controlInstructions = new JTextArea();
        controlInstructions.setBackground(PRIMARY_COLOR);
        controlInstructions.setForeground(Color.WHITE);
        controlInstructions.setFont(new Font("Arial", Font.BOLD, 15));
        controlInstructions.setText("Controls:\n\n" +
                "    Movement\t          -         Key\n\n" +
                "      Move Up\t\t↑\n" +
                "      Move Left\t\t←\n" +
                "      Move Right\t\t→\n" +
                "      Move Down\t↓\n");
        controlInstructions.setMaximumSize(new Dimension(350, 200));
        controlInstructions.setPreferredSize(new Dimension(125, 100));


        // create the panel for the text areas, blankPanel, and the back button.
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(PRIMARY_COLOR);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
        contentPanel.add(Box.createHorizontalStrut(8));
        contentPanel.add(objectiveInstructions);
        contentPanel.add(Box.createHorizontalStrut(0));
        contentPanel.add(blankPanel);
        contentPanel.add(controlInstructions);
        contentPanel.add(Box.createHorizontalStrut(4));
        

        // add the panels and back button to the frame
        Box container = Box.createVerticalBox(); // create a vertical box container. 
        container.setBorder(new EmptyBorder(30, 15, 0, 15)); // add a top margin to the container
        container.setBackground(PRIMARY_COLOR);
        container.add(headerPanel);
        container.add(Box.createVerticalStrut(4)); // add a vertical gap between the header and the instructions
        container.add(contentPanel);
        container.add(Box.createVerticalStrut(0)); // add a vertical gap between the instructions and the back button
        container.add(backPanel);

        add(container);

        // set the size and center the frame
        setSize(1280, 720);
        setMinimumSize(new Dimension(640, 360)); // Prevent UI structure from breaking down
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * ActionPerformed method. This responds to the buttons interacted with by the user.
     * 
     * This method gets called when the user clicks one the back button.
     * When the button is clicked, it creates a MainMenu object and disposes of the current frame.
     * 
     * @param e The ActionEvent object that carries information regarding how the button has been interacted with
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
            dispose();
        }
    }


}

