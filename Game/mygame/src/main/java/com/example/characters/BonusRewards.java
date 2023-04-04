package com.example.characters;

import java.io.IOException;
import java.util.Random;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.awt.Graphics2D;
import com.example.game.GameEngine;

public class BonusRewards extends Character {
    private int duration;
    private boolean expired;
    private int randomTimeBetweenBonus; // Number of ticks before next bonus appears
    private int rewardAmount;
    private Random random;
    private GameEngine gameBarrier;
    private boolean visible;
    private boolean isCollected;

    public BonusRewards(int rewardAmount, int x, int y, int duration, GameEngine gameEngine) {
        super(x, y, "");
        this.duration = duration;
        this.expired = false;
        this.visible = true;
        this.randomTimeBetweenBonus = 0;
        this.random = new Random();
        this.gameBarrier = gameEngine;
        this.isCollected = false;
        getBonusRewardsSprite();
    }

    public boolean checkCollision() {
        return gameBarrier.collisionDetector.checkCells(this);
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

    // getters and setters for the visible field
    public boolean isCollected() {
        return isCollected;
    }

    public void setCollecter(boolean collected) {
        this.isCollected = collected;
    }

    public void claimReward(MainCharacter mainChar) {
        int scoreEarned = getRewardAmount();
        int dx = mainChar.getX() - x;
        int dy = mainChar.getY() - y;
        double distance = Math.sqrt(dx * dx + dy * dy);

        // check if enemy is already adjacent to the main character
        if (distance < gameBarrier.cellSize) {
            mainChar.score += scoreEarned;
            System.out.println("Score after Bonus: " + mainChar.score);
            isCollected = true;
            spawning();
        }
    }

    public void update(MainCharacter mainChar) {
        if (!isExpired() && isVisible()) {
            // Lower duration left on bonus until it becomes 0;
            duration--;
            if (duration <= 0) {
                setRewardAmount(0);
                expired = true;
                visible = false;
                randomTimeBetweenBonus = random.nextInt(10);
            }
            claimReward(mainChar);
            isCollected = false;
            System.out.println("EXPIRED: " + expired + " DURATION: " + duration + " RANDOM: " + randomTimeBetweenBonus);
        } else {
            if (randomTimeBetweenBonus == 0) {
                expired = false;
                visible = true;
                duration = random.nextInt(20); // Between 200 - 400
                setRewardAmount(200); // Set new bonus reward amount to 100;
                spawning();
                if (duration <= 0) {
                    expired = false;
                    visible = true;
                }
            } else {
                System.out.println("X: " + x + " Y: " + y);
                randomTimeBetweenBonus--;
            }
        }
    }

    public void spawning() {
        relocate();
        while (gameBarrier.collisionDetector.checkCells(this) == true) {
            relocate();
            System.out.println("X: " + x + " Y: " + y);
            System.out.println("IT RELOCATE FOR STATIC");
        }
    }

    private void relocate() {
        x = random.nextInt(20);
        y = random.nextInt(20);
        x = x * gameBarrier.cellSize;
        y = y * gameBarrier.cellSize;
    }

    public void getBonusRewardsSprite() {
        try {
            bonusReward = ImageIO.read(getClass().getResourceAsStream("/images/book/specialRewards.png"));

        } catch (IOException e) {
            System.out.println("FAIL FIL FAIL");
            e.printStackTrace();
            System.out.println("Error loading images: " + e.getMessage());
        }
    }

    public void draw(Graphics2D graphics) {
        if (isVisible()) {
            BufferedImage image = bonusReward;
            graphics.drawImage(image, x, y, gameBarrier.cellSize, gameBarrier.cellSize, null);
        }
    }
}
