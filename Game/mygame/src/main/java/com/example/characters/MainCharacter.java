package com.example.characters;

public class MainCharacter extends Character {
    // constructor
    public MainCharacter(int x, int y, int score) {
        super(x, y, score);
    }

    @Override
    public void moveUp() {
        // move the character up by one cell
        // update the x coordinate and score accordingly
    }

    @Override
    public void moveDown() {
        // move the character down by one cell
        // update the x coordinate and score accordingly
    }

    @Override
    public void moveLeft() {
        // move the character left by one cell
        // update the y coordinate and score accordingly
    }

    @Override
    public void moveRight() {
        // move the character right by one cell
        // update the y coordinate and score accordingly
    }
}
