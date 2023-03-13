package com.example.game;
import com.example.characters.MainCharacter;
public class CollisionDetector {
  GameEngine gameBarrier;
  public CollisionDetector(GameEngine gameEngine) {
    this.gameBarrier = gameEngine;
  }
  public void checkCells(MainCharacter character){
    int charLeftMapX = 960 + 8;
    int charRightMapX = 960 + 8 + 32;
    int charTopMapY = 960 + 16;
    int charBottomMapY = 960 + 16 + 32;

    int charLeftCol = charLeftMapX/gameBarrier.cellSize;
    int charRightCol = charRightMapX/gameBarrier.cellSize;
    int charTopRow = charTopMapY/gameBarrier.cellSize;
    int charBottomRow = charBottomMapY/gameBarrier.cellSize;

    int cellNum1, cellNum2;

    switch(character.direction){
      case "up":
        charTopRow = (charTopMapY - gameBarrier.cellSize)/gameBarrier.cellSize;
        cellNum1 = gameBarrier.gameWorld.levelOne.mapCells[charLeftCol][charTopRow];
        cellNum2 = gameBarrier.gameWorld.levelOne.mapCells[charRightCol][charTopRow];
        if(gameBarrier.gameWorld.levelOne.cell[cellNum1].collision == true || gameBarrier.gameWorld.levelOne.cell[cellNum2].collision == true){
          character.collisionOn = true;
        }
        break;
      case "down":
        character.collisionOn = true;
        break;
      case "left":

        break;
      case "right":

        break;
      default:
        break;
    }
  }
}
