package com.example.game;

import java.awt.Rectangle;
import com.example.game.GameEngine;

public class EventHandler {
    GameEngine gameEngine;

    EventRectangle[][][] eventRect;

    private int previousEventX, previousEventY;

    public boolean canTouchEvent = true;
    int tempMap, tempCol, TempRow;

    /*

    public EventHandler(GameEngine gameEngine){
        this.gameEngine = gameEngine;
        this.eventRect = new EventRectangle[gameEngine.maxMap][gameEngine.maxScreenCol][gameEngine.maxScreenRow];

        int map = 0;
        int col = 0;
        int row = 0;

        while (map< gameEngine.maxMap && col < gameEngine.maxScreenCol && row<gameEngine.maxScreenRow){
            eventRect[map][col][row] =new EventRectangle();
            eventRect[map][col][row].x = 23;
            eventRect[map][col][row].y = 23;
            eventRect[map][col][row].width =2;
            eventRect[map][col][row].height =2;
            eventRect[map][col][row].setEventRectDefaultX(eventRect[map][col][row].x);
            eventRect[map][col][row].setEventRectDefaultY(eventRect[map][col][row].y);

            col++;
            if(col == gameEngine.maxScreenCol){
                col = 0;
                row++;
                if(row == gameEngine.maxScreenRow){
                    row=0;
                    map++;
                }
        }

    }
    public void checkEvent(){
        int xDistance = Math.abs(gameEngine.mainChar.getX() - previousEventX);
        int yDistance = Math.abs(gameEngine.mainChar.getY() - previousEventY) ;
        int distance = Math.max(xDistance, yDistance);
        if(distance > gameEngine.cellSize){
            canTouchEvent = true;
        }
        if(canTouchEvent == true){
            if (hit(0,0,10),"up" == true) {teleport(1,2,2);}
        }
    }

    public boolean hit(int map, int col, int row, String requiredDirection) {
        boolean hit = false;

        if (map == gameEngine.currentMap) {
            gameEngine.mainChar.collisionOn.x = gameEngine.mainChar.getX() + gameEngine.mainChar.collisionOn.x;
            gameEngine.mainChar.collisionOn.y = gameEngine.mainChar.getY() + gameEngine.mainChar.collisionOn.y;

            eventRect[map][col][row].x = col * gameEngine.cellSize + eventRect[map][col][row].x;
            eventRect[map][col][row].y = row * gameEngine.cellSize + eventRect[map][col][row].y;

            if (gameEngine.mainChar.collisionOn.intersects(eventRect[map][col][row]) && !eventRect[map][col][row].isEventDone()) {
                if (gameEngine.mainChar.collisionOn.contentEquals(requiredDirection) || requiredDirection.contentEquals("any")) {
                    hit = true;

                    previousEventX = gameEngine.mainChar.getX();
                    previousEventY = gameEngine.mainChar.getY();
                }
            }

            gameEngine.mainChar.collisionOn.x = gameEngine.mainChar.getCollisionDefaultX();
            gameEngine.mainChar.collisionOn.y = gameEngine.mainChar.getCollisionDefaultY();

            eventRect[map][col][row].x = eventRect[map][col][row].getEventRectDefaultX();
            eventRect[map][col][row].y = eventRect[map][col][row].getEventRectDefaultY();
        }

        return hit;
    }
    //teleport

    private void teleport(int map, int col, int row) {
        gameEngine.currentMap = map;
        //where is the main char
        gameEngine.mainChar.getX() = gameEngine.cellSize * col;
        gameEngine.mainChar.getY() = gameEngine.cellSize * row;
        previousEventX = gameEngine.mainChar.getX();
        previousEventY = gameEngine.mainChar.getY();
        canTouchEvent = false;
    }

     */

}
