package com.example.characters;

import com.example.game.GameEngine;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MovingEnemy extends Character {
    GameEngine gameBarrier;
    public MovingEnemy(int x, int y, int damage, GameEngine gameEngine) {
        super(x, y, "down");
        this.gameBarrier = gameEngine;  // This is the gameBarrier object
    }

    public void moveTowards(Character character) {
        // implementation to move towards the main character
    }

    /*
    This method is called when the character is created to load the character's sprite
     */
    public void getMovingEnemySprite() {
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/images/Main_CHARACTER/main_back_leftfoot-1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/images/Main_CHARACTER/main_back_right-1.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/images/Main_CHARACTER/mainfront_leftfoot-1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/images/Main_CHARACTER/mainfront_rightfoot-1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/images/Main_CHARACTER/main_left_stopmotion-1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/images/Main_CHARACTER/main_left_walking-1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/images/Main_CHARACTER/main_right_stopmotion-1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/images/Main_CHARACTER/main_right_walking-1.png"));

        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error loading images: " + e.getMessage());
        }
    }

    /*
    This method is called every frame to update the enemy's state
     */
    public void draw(Graphics2D graphics) {
        BufferedImage image = null;
        switch(direction){
            case "up":
                if(spriteMovement == 1){
                    image = up1;
                }
                else if(spriteMovement == 2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteMovement == 1){
                    image = down1;
                }
                else if(spriteMovement == 2){
                    image = down2;
                }
                break;
            case "left":
                if(spriteMovement == 1){
                    image = left1;
                }
                else if(spriteMovement == 2){
                    image = left2;
                }
                break;
            case "right":
                if(spriteMovement == 1){
                    image = right1;
                }
                else if(spriteMovement == 2){
                    image = right2;
                }
                break;
            default:
                image = down1;
                break;
        }
        graphics.drawImage(image, x, y, gameBarrier.cellSize, gameBarrier.cellSize, null);
    }
}


