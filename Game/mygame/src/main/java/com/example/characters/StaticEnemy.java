package com.example.characters;

import com.example.game.GameEngine;

public class StaticEnemy extends Character {
    private int damageAmount;
    GameEngine gameBarrier;
    public StaticEnemy(int x, int y, int damage, GameEngine gameEngine) {
        super(x, y, "");
        this.gameBarrier = gameEngine;
        getStaticEnemySprite();
    }

    // getters and setters for the visible field
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void update(double elapsed, MainCharacter mainChar) {
        int distance = gameBarrier.cellSize;
        collisionOn = false;
        gameBarrier.collisionDetector.checkCells(this);
    }

    public int getDamageAmount() {
        return damageAmount;
    }

    public void setDamageAmount(int amount) {
        damageAmount = amount;
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
}
