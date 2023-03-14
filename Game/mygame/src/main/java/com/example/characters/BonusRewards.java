package com.example.characters;

import com.example.game.CollisionDetector;


public class BonusRewards extends Rewards {
    private int duration;
    private boolean expired;
    private int randomTimeBetweenBonus;  // Number of ticks before next bonus appears
    private Random random;
    private CollisionDetector collisionDetector;

    public BonusRewards(int rewardAmount, int x, int y, int duration, CollisionDetector collisionDetector) {
        super(rewardAmount, x, y);
        this.duration = duration;
        this.expired = false;
        this.randomTimeBetweenBonus = 0;
        this.random = new Random();
        this.collisionDetector = collisionDetector;
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

    public void update() {
        if (!expired) {
            //  Lower duration left on bonus until it becomes 0;
            duration--;
            if (duration == 0) {
                setRewardAmount(0);
                expired = true;
                randomTimeBetweenBonus = random.nextInt(750) + 500;
            }
        }
        else {
            if (randomTimeBetweenBonus == 0) {
                expired = false;
                duration  = random.nextInt(200) + 200; // Between 200 - 400
                setRewardAmount(100);  // Set new bonus reward amount to 100;

                x = random.nextInt(100);
                y = random.nextInt(100);
                while (collisionDetector.detectCollision(x, y)) {
                    x = random.nextInt(100);
                    y = random.nextInt(100);
                }
            }
            else {
                randomTimeBetweenBonus--;
            }
        }
    }
    
}
