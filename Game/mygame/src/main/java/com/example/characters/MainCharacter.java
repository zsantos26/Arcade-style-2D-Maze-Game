package com.example.characters;

import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.example.game.GameEngine;
import com.example.game.GameInput;


// import com.example.characters.Rewards;  // For reward.OnReward(x, y)) and reward.claimReward();

public class MainCharacter extends Character {
    GameEngine gameBarrier;

    // constructor for the MainCharacter class
    public MainCharacter(int x, int y, GameEngine gameEngine) {
        super(x, y, "down");
        if (gameEngine == null) {
            throw new IllegalArgumentException("gameEngine cannot be null");
        }
        this.gameBarrier = gameEngine;


        // direction = "down"; // set the initial direction of the character
        getPlayerSprite();
    }

    /*
    This method is called when the player presses a key to move the character
     */
    public void moveUp() {
        // move the character up by one cell
        // update the x coordinate and score accordingly
        direction = "up";

    }

    public void moveDown() {
        // move the character down by one cell
        // update the x coordinate and score accordingly
        direction = "down";

    }

    public void moveLeft() {
        // move the character left by one cell
        // update the y coordinate and score accordingly
        direction = "left";

    }

    public void moveRight() {
        // move the character right by one cell
        // update the y coordinate and score accordingly
        direction = "right";

    }

    /*
    This method is called when the character is created to load the character's sprite
     */
    public void getPlayerSprite() {
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
    This method is called every frame to update the character's state
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
        // graphics.setColor(Color.red);
        // graphics.fillRect(x, y, 48, 48);
    }

    /*
    * This method is called every frame to update the character's position
     */
    public void update(GameInput keyBoard, double elapsed){
            double distance = elapsed * gameBarrier.cellSize;
            if (keyBoard.upPressed == true) {
                moveUp();
            }
            else if (keyBoard.downPressed == true) {
                moveDown();
            }
            else if (keyBoard.leftPressed == true) {
                moveLeft();
            }
            else if (keyBoard.rightPressed == true) {
                moveRight();
            }

        collisionOn = false;
        gameBarrier.collisionDetector.checkCells(this);

        if (collisionOn == false){
            switch(direction){
                case "up":
                    y -= distance;
                    break;
                case "down":
                    y += distance;
                    break;
                case "left":
                    x -= distance;
                    break;
                case "right":
                    x += distance;
                    break;
                default:
                    break;
            }
        }
        spriteCounter++;
        if (spriteCounter > 4) {
            if(spriteMovement == 1){
                spriteMovement = 2;
            }
            else if(spriteMovement == 2){
                spriteMovement = 1;
            }
            spriteCounter = 0;
        }
        try {
            Thread.sleep(50); // Add a delay of 50 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
