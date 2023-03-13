package com.example.characters;

import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.example.game.GameEngine;
import com.example.game.GameInput;

import javafx.scene.shape.Rectangle;
public class MainCharacter extends Character {
    GameEngine gameBarrier;

    // constructor for the MainCharacter class
    public MainCharacter(int x, int y, GameEngine gameEngine) {
        super(x, y);
        if (gameEngine == null) {
            throw new IllegalArgumentException("gameEngine cannot be null");
        }
        this.gameBarrier = gameEngine;
        getPlayerSprite();
        direction = "down"; // set the initial direction of the character

        hitBox = new Rectangle(8,16,gameEngine.cellSize-16,gameEngine.cellSize-16);
    }

    // set direction of the character
    public void setDirection(String direction) {
        this.direction = direction;
    }

    // get direction of the character
    public String getDirection(){
        return direction;
    }

    /*
    This method is called when the player presses a key to move the character
     */
    @Override
    public void moveUp() {
        // move the character up by one cell
        // update the x coordinate and score accordingly
        direction = "up";

    }

    @Override
    public void moveDown() {
        // move the character down by one cell
        // update the x coordinate and score accordingly
        direction = "down";

    }

    @Override
    public void moveLeft() {
        // move the character left by one cell
        // update the y coordinate and score accordingly
        direction = "left";

    }

    @Override
    public void moveRight() {
        // move the character right by one cell
        // update the y coordinate and score accordingly
        direction = "right";

    }

    /*
    This method is called when the character is created to load the character's sprite
     */
    @Override
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
            System.out.println("FAIL FIL FAIL");
            e.printStackTrace();
            System.out.println("Error loading images: " + e.getMessage());
        }
    }

    /*
    This method is called every frame to update the character's state
     */
    @Override
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
    public void update(GameInput keyBoard){
        if (keyBoard.upPressed == true) {
            moveUp();
        }
        if (keyBoard.downPressed == true) {
            moveDown();
        }
        if (keyBoard.leftPressed == true) {
            moveLeft();
        }
        if (keyBoard.rightPressed == true) {
            moveRight();
        }
        collisionOn = false;
        gameBarrier.collisionDetector.checkCells(this);

        if (collisionOn == false){
            switch(direction){
                case "up":
                    y -= gameBarrier.cellSize;
                    break;
                case "down":
                    y += gameBarrier.cellSize;
                    break;
                case "left":
                    x -= gameBarrier.cellSize;
                    break;
                case "right":
                    x += gameBarrier.cellSize;
                    break;
                default:
                    break;
            }
    }
        spriteCounter++;
        if (spriteCounter > 30) {
            if(spriteMovement == 1){
                spriteMovement = 2;
            }
            else if(spriteMovement == 2){
                spriteMovement = 1;
            }
            spriteCounter = 0;
        }
    }
}
