package com.example.characters;

public abstract class Enemy {
    private int x;
    private int y;
    private int damage;

    public Enemy(int x, int y, int damage) {
        this.x = x;
        this.y = y;
        this.damage = damage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDamage() {
        return damage;
    }
}

