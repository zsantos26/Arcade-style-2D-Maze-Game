package com.example.characters;

public abstract class Character {
    protected int x; // x coordinate of the character
    protected int y; // y coordinate of the character
    protected int score; // current score of the character
    
    // constructor
    public Character(int x, int y, int score) {
        this.x = x;
        this.y = y;
        this.score = score;
    }
    
    // move the character up by one cell
    public abstract void moveUp();
    
    // move the character down by one cell
    public abstract void moveDown();
    
    // move the character left by one cell
    public abstract void moveLeft();
    
    // move the character right by one cell
    public abstract void moveRight();
    
    // update the character's score by the given amount
    public void updateScore(int amount) {
        score += amount;
    }
    
    // get the x coordinate of the character
    public int getX() {
        return x;
    }
    
    // get the y coordinate of the character
    public int getY() {
        return y;
    }
    
    // get the score of the character
    public int getScore() {
        return score;
    }
}


