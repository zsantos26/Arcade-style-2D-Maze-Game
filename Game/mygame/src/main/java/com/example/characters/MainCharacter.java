package com.example.characters;

import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import com.example.game.GameEngine;
import com.example.game.GameInput;

public class MainCharacter extends Character {
    GameEngine gameBarrier;
    StaticRewards staticRewards;
    public int score = 0;

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /*
     * This method is called when the player presses a key to move the character
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
     * This method is called when the character is created to load the character's
     * sprite
     */
    public void getPlayerSprite() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/images/Main_CHARACTER/main_char_back_left-1.png.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/images/Main_CHARACTER/main_char_back_right-1.png.png"));
            down1 = ImageIO
                    .read(getClass().getResourceAsStream("/images/Main_CHARACTER/main_char_front_left-1.png.png"));
            down2 = ImageIO
                    .read(getClass().getResourceAsStream("/images/Main_CHARACTER/main_char_front_right-1.png.png"));
            left1 = ImageIO
                    .read(getClass().getResourceAsStream("/images/Main_CHARACTER/main_char_left_stand-1.png.png"));
            left2 = ImageIO
                    .read(getClass().getResourceAsStream("/images/Main_CHARACTER/main_char_left_walk-1.png.png"));
            right1 = ImageIO.read(
                    getClass().getResourceAsStream("/images/Main_CHARACTER/main_char_right_stand-1.png-1.png.png"));
            right2 = ImageIO
                    .read(getClass().getResourceAsStream("/images/Main_CHARACTER/main_char_right_walk-1.png.png"));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading images: " + e.getMessage());
        }
    }

    /*
     * This method is called every frame to update the character's state
     */
    public void draw(Graphics2D graphics) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (spriteMovement == 1) {
                    image = up1;
                } else if (spriteMovement == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteMovement == 1) {
                    image = down1;
                } else if (spriteMovement == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteMovement == 1) {
                    image = left1;
                } else if (spriteMovement == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteMovement == 1) {
                    image = right1;
                } else if (spriteMovement == 2) {
                    image = right2;
                }
                break;
            default:
                image = down1;
                break;
        }
        graphics.drawImage(image, x, y, gameBarrier.cellSize, gameBarrier.cellSize, null);
    }

    /*
     * This method is called every frame to update the character's position
     */
    public void update(GameInput keyBoard) {
        int distance = gameBarrier.cellSize;
        if (keyBoard.upPressed == true) {
            moveUp();
        } else if (keyBoard.downPressed == true) {
            moveDown();
        } else if (keyBoard.leftPressed == true) {
            moveLeft();
        } else if (keyBoard.rightPressed == true) {
            moveRight();
        }

        collisionOn = false;
        gameBarrier.collisionDetector.checkCells(this);

        if (collisionOn == false) {
            switch (direction) {
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
            if (spriteMovement == 1) {
                spriteMovement = 2;
            } else if (spriteMovement == 2) {
                spriteMovement = 1;
            }
            spriteCounter = 0;
        }
    }
}
