package com.example.characters;

import java.io.IOException;
import java.util.Random;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.awt.Graphics2D;
import com.example.game.CollisionDetector;
import com.example.game.GameEngine;


public class StaticRewards extends Character {
    private int rewardAmount;
    private Random random;
    private CollisionDetector collisionDetector;
    private GameEngine gameBarrier;
    private boolean visible;
    public StaticRewards(int rewardAmount, int x, int y, GameEngine gameEngine, CollisionDetector collisionDetector) {
        super(x, y,"");
        this.visible = true;
        this.random = new Random();
        this.collisionDetector = collisionDetector;
        this.gameBarrier = gameEngine;
        getStaticRewardsSprite();
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
        //Still thinking if I should make the Static Rewards Fixed or Randomly Spawned?????
        visible = true;
        if(collisionDetector.checkCells(this)==true){
            x = random.nextInt(20);
            y = random.nextInt(20);
            x = x * gameBarrier.cellSize;
            y = y * gameBarrier.cellSize;
            System.out.println("X: " + x + " Y: " + y);
            System.out.println("IT RELOCATE");
        }
        int amount = random.nextInt(200);
        setRewardAmount(amount);  // Set new bonus reward amount to 100;
    }



    public void getStaticRewardsSprite() {
        try{
            staticReward1 = ImageIO.read(getClass().getResourceAsStream("/images/book/note.png"));
            staticReward2 = ImageIO.read(getClass().getResourceAsStream("/images/book/textbook.png"));
        }catch(IOException e){
            System.out.println("FAIL FIL FAIL");
            e.printStackTrace();
            System.out.println("Error loading images: " + e.getMessage());
        }
    }

    public void draw(Graphics2D graphics){
        if(isVisible()){
            BufferedImage image = null;
            int spriteGenerate = random.nextInt(1);
            if(spriteGenerate == 0){
                image = staticReward1;
            }
            else{
                image = staticReward2;
            }
            graphics.drawImage(image, x, y, gameBarrier.cellSize, gameBarrier.cellSize, null);
        }
    }
}

