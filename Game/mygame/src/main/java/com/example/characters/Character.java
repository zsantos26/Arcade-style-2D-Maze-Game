package com.example.characters;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import com.example.game.GameInput;

public abstract class Character {
    public int x; // x coordinate of the character
    public int y; // y coordinate of the character // speed of the character
    // protected int score; // current score of the character
    //Sprite Animations
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteMovement = 1;

    // constructor
    public Character(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // move the character up by one cell
    public abstract void moveUp(int cellSize);
    // move the character down by one cell
    public abstract void moveDown(int cellSize);
    // move the character left by one cell
    public abstract void moveLeft(int cellSize);
    // move the character right by one cell
    public abstract void moveRight(int cellSize);
    // get the sprite of the character
    public abstract void getPlayerSprite();
    // set the direction of the character
    public abstract void setDirection(String direction);
    // get the direction of the character
    public abstract String getDirection();
    // update the character based on the keyboard input
    public abstract void update(GameInput keyBoard, int cellSize);
    // draw the character on the screen
    public abstract void draw(Graphics2D graphics, int cellSize);

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
}


