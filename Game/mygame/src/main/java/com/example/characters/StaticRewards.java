package com.example.characters;


public class StaticRewards extends Rewards {
    public StaticRewards(int rewardAmount, int x, int y) {
        super(rewardAmount, x, y);
    }
    
    @Override
    public void claimReward() {
        // Remove the reward from the board
    }
}

