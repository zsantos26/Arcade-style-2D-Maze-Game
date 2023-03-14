package com.example.characters;

import java.io.IOException;
import java.util.Random;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.awt.Graphics2D;
import com.example.game.CollisionDetector;
import com.example.game.GameEngine;


public class BonusRewards extends Character {
    private int duration;
    private boolean expired;
    private int randomTimeBetweenBonus;  // Number of ticks before next bonus appears
    private int rewardAmount;
    private Random random;
    private CollisionDetector collisionDetector;
    private GameEngine gameBarrier;
    private boolean visible;

    public BonusRewards(int rewardAmount, int x, int y, int duration, GameEngine gameEngine, CollisionDetector collisionDetector) {
        super(x, y, "");
        this.duration = duration;
        this.expired = false;
        this.visible = true;
        this.randomTimeBetweenBonus = 0;
        this.random = new Random();
        this.collisionDetector = collisionDetector;
        this.gameBarrier = gameEngine;
        getBonusRewardsSprite();
    }

    public int getDuration() {
        return duration;
    }

    public int getRandomTimeBetweenBonus() {
        return randomTimeBetweenBonus;
    }

    public boolean isExpired() {
        return expired;
    }

    // getters and setters for the visible field
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(int amount) {
        rewardAmount = amount;
    }

    public boolean onReward(int charX, int charY) {
        return x == charX && y == charY;
    }

    public int claimReward() {
        int scoreEarned = getRewardAmount();
        setRewardAmount(0);
        return scoreEarned;
    }

    public void update() {
        if (!isExpired() && isVisible()) {
            //  Lower duration left on bonus until it becomes 0;
            duration--;
            if (duration == 0) {
                setRewardAmount(0);
                expired = true;
                visible = false;
                randomTimeBetweenBonus = random.nextInt(10);

            }
            System.out.println("XPIRED: " + expired + " DURATION: " + duration + " RANDOM: " + randomTimeBetweenBonus);
        }
        else {
            if (randomTimeBetweenBonus == 0) {
                expired = false;
                visible = true;
                duration  = random.nextInt(20); // Between 200 - 400
                setRewardAmount(100);  // Set new bonus reward amount to 100;
                do{
                    x = random.nextInt(20);
                    y = random.nextInt(20);
                    x = x * gameBarrier.cellSize;
                    y = y * gameBarrier.cellSize;
                    System.out.println("X: " + x + " Y: " + y);
                    System.out.println("IT RELOCATE");
                }while(collisionDetector.checkCells(this)==true);
                if(duration == 0){
                    expired = false;
                    visible = true;
                }
            }
            else {
                System.out.println("X: " + x + " Y: " + y);
                randomTimeBetweenBonus--;
            }
        }
    }


    public void getBonusRewardsSprite() {
        try{
            bonusReward = ImageIO.read(getClass().getResourceAsStream("/images/book/specialRewards.png"));

        }catch(IOException e){
            System.out.println("FAIL FIL FAIL");
            e.printStackTrace();
            System.out.println("Error loading images: " + e.getMessage());
        }
    }

    public void draw(Graphics2D graphics){
        if(isVisible()){
            BufferedImage image = bonusReward;
            graphics.drawImage(image, x, y, gameBarrier.cellSize, gameBarrier.cellSize, null);
        }
    }
}
