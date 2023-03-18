package com.example.characters;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import com.example.game.GameEngine;

public class StaticEnemy extends Character {
    private int damageAmount;
    private GameEngine gameBarrier;
    private Random random;
    private boolean visible;
    private boolean isDetected;

    public StaticEnemy(int x, int y, int damage, GameEngine gameEngine) {
        super(x, y, "");
        this.random = new Random();
        this.gameBarrier = gameEngine;
        this.isDetected = false;
        getStaticEnemySprite();
    }

    public boolean checkCollision() {
        return gameBarrier.collisionDetector.checkCells(this);
    }

    // getters and setters for the visible field
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getDamageAmount() {
        return damageAmount;
    }

    public void setDamageAmount(int amount) {
        damageAmount = amount;
    }

    // getters and setters for the visible field
    public boolean isDetected() {
        return isDetected;
    }

    public void setDetected(boolean detect) {
        this.isDetected = detect;
    }

    public void update(MainCharacter mainChar) {
        // Still thinking if I should make the Static Rewards Fixed or Randomly
        // Spawned?????
        int amount = random.nextInt(200);
        setDamageAmount(amount);
        punishment(mainChar);
        isDetected = false;
    }

    public void punishment(MainCharacter mainChar) {
        int damageReceived = getDamageAmount();
        int dx = mainChar.getX() - x;
        int dy = mainChar.getY() - y;
        double distance = Math.sqrt(dx * dx + dy * dy);

        // check if enemy is already adjacent to the main character
        if (distance < gameBarrier.cellSize) {
            mainChar.score -= damageReceived;
            System.out.println("Score: " + mainChar.score);
            isDetected = true;
            spawning();
        }
    }

    public void spawning() {
        visible = true;
        x = random.nextInt(20);
        y = random.nextInt(20);
        x = x * gameBarrier.cellSize;
        y = y * gameBarrier.cellSize;
        while (gameBarrier.collisionDetector.checkCells(this) == true) {
            x = random.nextInt(20);
            y = random.nextInt(20);
            x = x * gameBarrier.cellSize;
            y = y * gameBarrier.cellSize;
            System.out.println("X: " + x + " Y: " + y);
            System.out.println("IT RELOCATE FOR STATIC");
        }
    }

    public void getStaticEnemySprite() {
        try {
            staticEnemy1 = ImageIO.read(getClass().getResourceAsStream("/images/cctv/cctv_left-1.png.png"));
            staticEnemy2 = ImageIO.read(getClass().getResourceAsStream("/images/cctv/cctv-1.png.png"));
        } catch (IOException e) {
            System.out.println("FAIL FIL FAIL");
            e.printStackTrace();
            System.out.println("Error loading images: " + e.getMessage());
        }
    }

    public void draw(Graphics2D graphics) {
        BufferedImage image = staticEnemy1;
        graphics.drawImage(image, x, y, gameBarrier.cellSize, gameBarrier.cellSize, null);
    }
}
