package com.example.characters;

import java.awt.image.BufferedImage;

import javafx.scene.shape.Rectangle;

public abstract class Character {
    public int x; // x coordinate of the character
    public int y; // y coordinate of the character // speed of the character
    public String direction;
    // protected int score; // current score of the character
    // Sprite Animations
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, bonusReward, staticReward1,
            staticReward2, staticEnemy1, staticEnemy2;

    public int spriteCounter = 0;
    public int spriteMovement = 1;

    public int choice = 0;
    public Rectangle hitBox;
    public boolean collisionOn = false;

    // constructor
    public Character(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    // set direction of the character
    public void setDirection(String direction) {
        this.direction = direction;
    }

    // get direction of the character
    public String getDirection() {
        return direction;
    }

    public void setX(int newX) {
        this.x = newX;
    }

    public void setY(int newY) {
        this.y = newY;
    }

    // get the x coordinate of the character
    public int getX() {
        return x;
    }

    // get the y coordinate of the character
    public int getY() {
        return y;
    }
}
