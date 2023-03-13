package com.example.game;
import com.example.characters.MainCharacter;
public class CollisionDetector {
  GameEngine gameBarrier;
  public CollisionDetector(GameEngine gameEngine) {
    this.gameBarrier = gameEngine;
  }
  public void checkCells(MainCharacter character){
    int characterX = (int) (character.x/gameBarrier.cellSize);
    int characterY = (int) (character.y/gameBarrier.cellSize);

    switch(character.direction){
      case "up":
        if (gameBarrier.gameWorld.levelOne.mapCells[characterX][characterY-1] == 1){
          character.collisionOn = true;
        }
        else{
          character.collisionOn = false;
        }
        break;
      case "down":
        if(gameBarrier.gameWorld.levelOne.mapCells[characterX][characterY+1] == 1){
          character.collisionOn = true;
        }
        else{
          character.collisionOn = false;
        }
        break;
      case "left":
        if(gameBarrier.gameWorld.levelOne.mapCells[characterX-1][characterY] == 1){
          character.collisionOn = true;
        }
        else{
          character.collisionOn = false;
        }
        break;
      case "right":
        if(gameBarrier.gameWorld.levelOne.mapCells[characterX+1][characterY] == 1){
          character.collisionOn = true;
        }
        else{
          character.collisionOn = false;
        }
        break;
      default:
        break;
    }
  }
}
