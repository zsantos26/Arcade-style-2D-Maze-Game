package com.example.characters;

public class BonusRewards extends Rewards {
    private int duration;
    
    public BonusRewards(int rewardAmount, int x, int y, int duration) {
        super(rewardAmount, x, y);
        this.duration = duration;
    }
    
    public int getDuration() {
        return duration;
    }
    
    @Override
    public void claimReward() {
        // Remove the reward from the board
    }
}
