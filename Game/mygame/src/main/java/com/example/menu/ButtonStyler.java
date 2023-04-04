package com.example.menu;

import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;

public class ButtonStyler {
    public static void styleButton(JButton button, int width, int height, int fontSize) {
        button.setUI(new MetalButtonUI());  // Set button UI
        button.setPreferredSize(new Dimension(width, height));  // Set preffered size
        button.setBackground(new Color(166, 25, 46)); // Set the background color to SFU secondary color
        button.setForeground(Color.WHITE);  // set text colour
        button.setFont(new Font(null, Font.PLAIN, fontSize));
        button.setFocusPainted(false); // When a button is selected (but not clicked), disables visual cue
    }
}
