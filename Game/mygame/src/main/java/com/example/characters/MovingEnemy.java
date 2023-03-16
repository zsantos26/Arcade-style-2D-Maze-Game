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
        getMovingEnemySprite();
    }

public String moveTowards(MainCharacter mainchar) {
    // calculate distance between the enemy and the main character
    double dx = mainchar.getX() - x;
    double dy = mainchar.getY() - y;
    double distance = Math.sqrt(dx * dx + dy * dy);

    // check if enemy is already adjacent to the main character
    if (distance <= gameBarrier.cellSize) {
        // enemy has caught the main character, do something here
        return null;
    }

    // calculate the normalized direction vector towards the main character
    double dirX = dx / distance;
    double dirY = dy / distance;

    // move the enemy towards the main character
    x += dirX * gameBarrier.cellSize;
    y += dirY * gameBarrier.cellSize;

    // determine the direction that the enemy is moving
    if (Math.abs(dirX) > Math.abs(dirY)) {
        if (dirX > 0) {
            return "right";
        } else {
            return "left";
        }
    } else {
        if (dirY > 0) {
            return "down";
        } else {
            return "up";
        }
    }
}




    public void update(double elapsed, MainCharacter mainChar) {
        int distance = gameBarrier.cellSize;
        moveTowards(mainChar);
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
        if (spriteCounter > 0) {
            if(spriteMovement == 1){
                spriteMovement = 2;
            }
            else if(spriteMovement == 2){
                spriteMovement = 1;
            }
            spriteCounter = 0;
        }
        try {
            Thread.sleep(200); // Add a delay of 50 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
    This method is called when the character is created to load the character's sprite
     */
    public void getMovingEnemySprite() {
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/images/professor/professorbackright-1.png.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/images/professor/professorbackleft-1.png.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/images/professor/professor_front.png-1.png.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/images/professor/professor_front_right-1.png.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/images/professor/professorleftwalking-1.png.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/images/professor/professorleftstand-1.png.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/images/professor/professorrightwalking-1.png.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/images/professor/professorrightstand-1.png.png"));

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


