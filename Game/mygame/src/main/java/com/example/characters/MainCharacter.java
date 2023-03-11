package com.example.characters;

import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import com.example.game.GameInput;
public class MainCharacter extends Character {
    // constructor for the MainCharacter class
    public MainCharacter(int x, int y) {
        super(x, y);
        getPlayerSprite();
        direction = "down"; // set the initial direction of the character
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
    public void moveUp(int cellSize) {
        // move the character up by one cell
        // update the x coordinate and score accordingly
        direction = "up";
        y -= 48;
    }

    @Override
    public void moveDown(int cellSize) {
        // move the character down by one cell
        // update the x coordinate and score accordingly
        direction = "down";
        y += 48;
    }

    @Override
    public void moveLeft(int cellSize) {
        // move the character left by one cell
        // update the y coordinate and score accordingly
        direction = "left";
        x -= 48;
    }

    @Override
    public void moveRight(int cellSize) {
        // move the character right by one cell
        // update the y coordinate and score accordingly
        direction = "right";
        x += 48;
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
    public void draw(Graphics2D graphics, int cellSize) {
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
        graphics.drawImage(image, x, y, cellSize, cellSize, null);
        // graphics.setColor(Color.red);
        // graphics.fillRect(x, y, 48, 48);
    }

    /*
    * This method is called every frame to update the character's position
     */
    public void update(GameInput keyBoard, int cellSize){
        if (keyBoard.upPressed == true) {
            moveUp(cellSize);
        }
        if (keyBoard.downPressed == true) {
            moveDown(cellSize);
        }
        if (keyBoard.leftPressed == true) {
            moveLeft(cellSize);
        }
        if (keyBoard.rightPressed == true) {
            moveRight(cellSize);
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
