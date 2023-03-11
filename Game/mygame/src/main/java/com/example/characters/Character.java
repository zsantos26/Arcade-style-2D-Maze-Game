package com.example.characters;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Character {
    public int x; // x coordinate of the character
    public int y; // y coordinate of the character
    public int speed; // speed of the character
    // protected int score; // current score of the character
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteMovement = 1;

    
    // constructor
    public Character(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }
    
    // move the character up by one cell
    public abstract void moveUp();
    
    // move the character down by one cell
    public abstract void moveDown();
    
    // move the character left by one cell
    public abstract void moveLeft();
    
    // move the character right by one cell
    public abstract void moveRight();
    
    public abstract void getPlayerSprite();

    public abstract void setDirection(String direction);

    public abstract String getDirection();

    public abstract void draw(Graphics2D graphics);
    // update the character's score by the given amount
    // public void updateScore(int amount) {
    //     score += amount;
    // }
    
    // get the x coordinate of the character
    public int getX() {
        return x;
    }
    
    // get the y coordinate of the character
    public int getY() {
        return y;
    }
    
    // get the speed of the character
    public int getSpeed() {
        return speed;
    }
}


