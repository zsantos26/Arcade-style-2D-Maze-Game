package com.example.characters;

public abstract class Rewards {
    private int rewardAmount;
    private int x;
    private int y;
    
    public Rewards(int rewardAmount, int x, int y) {
        this.rewardAmount = rewardAmount;
        this.x = x;
        this.y = y;
    }
    
    public int getRewardAmount() {
        return rewardAmount;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public void setRewardAmount(int amount) {
        rewardAmount = amount;
    }
    
    public boolean onReward(int charX, int charY) {
        return x == charX && x == charY;
    }

    public int claimReward() {
        int scoreEarned = getRewardAmount();
        setRewardAmount(0);
        
        return scoreEarned;
    }

    
}


