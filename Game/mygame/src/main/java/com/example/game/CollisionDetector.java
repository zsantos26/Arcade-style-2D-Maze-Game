package com.example.game;
import com.example.characters.Character;
public class CollisionDetector {
  GameEngine gameBarrier;
  public CollisionDetector(GameEngine gameEngine) {
    this.gameBarrier = gameEngine;
  }

  public Boolean checkCells(Character character){
    int charLeftX = character.getX();
    int charRightX = character.getX();
    int charTopY = character.getY();
    int charBottomY = character.getY();

    int charLeftCol = charLeftX / gameBarrier.cellSize;
    int charRightCol = charRightX / gameBarrier.cellSize;
    int charTopRow = charTopY / gameBarrier.cellSize;
    int charBottomRow = charBottomY / gameBarrier.cellSize;

      int cellNum1, cellNum2, cellNum;
      switch(character.direction){
          case "up":
              if (charTopRow >= 0 && charTopRow < gameBarrier.maxScreenRow &&
                      charLeftCol >= 0 && charLeftCol < gameBarrier.maxScreenCol &&
                      charRightCol >= 0 && charRightCol < gameBarrier.maxScreenCol){
                  charTopRow = (charTopY - gameBarrier.cellSize) / gameBarrier.cellSize;
                  cellNum1 = gameBarrier.gameWorld.mapCells[gameBarrier.currentMap][charLeftCol][charTopRow];
                  cellNum2 = gameBarrier.gameWorld.mapCells[gameBarrier.currentMap][charRightCol][charTopRow];
                  if (gameBarrier.gameWorld.cell[cellNum1].collision || gameBarrier.gameWorld.cell[cellNum2].collision) {
                      character.collisionOn = true;
                      return true;
                  } else {
                      character.collisionOn = false;
                      return false;
                  }
              }
              break;
          case "down":
              if(charBottomRow >= 0 && charBottomRow < gameBarrier.maxScreenRow &&
                      charLeftCol >= 0 && charLeftCol < gameBarrier.maxScreenCol &&
                      charRightCol >= 0 && charRightCol < gameBarrier.maxScreenCol){
                  charBottomRow = (charBottomY + gameBarrier.cellSize) / gameBarrier.cellSize;
                  cellNum1 = gameBarrier.gameWorld.mapCells[gameBarrier.currentMap][charLeftCol][charBottomRow];
                  cellNum2 = gameBarrier.gameWorld.mapCells[gameBarrier.currentMap][charRightCol][charBottomRow];
                  if (gameBarrier.gameWorld.cell[cellNum1].collision || gameBarrier.gameWorld.cell[cellNum2].collision) {
                      character.collisionOn = true;
                      return true;
                  } else {
                      character.collisionOn = false;
                      return false;
                  }
              }
              break;
          case "left":
              charLeftCol = (charLeftX - gameBarrier.cellSize) / gameBarrier.cellSize;
              if (charLeftCol >= 0 && charLeftCol < gameBarrier.maxScreenCol) {
                  cellNum1 = gameBarrier.gameWorld.mapCells[gameBarrier.currentMap][charLeftCol][charTopRow];
                  cellNum2 = gameBarrier.gameWorld.mapCells[gameBarrier.currentMap][charLeftCol][charBottomRow];
                  if(gameBarrier.gameWorld.cell[cellNum1].collision == true || gameBarrier.gameWorld.cell[cellNum2].collision == true){
                      character.collisionOn = true;
                      return true;
                  }
              } else {
                  character.collisionOn = true;
                  return true;
              }
              break;
          case "right":
              charRightCol = (charRightX + gameBarrier.cellSize) / gameBarrier.cellSize;
              if (charRightCol >= 0 && charRightCol < gameBarrier.maxScreenCol) {
                  cellNum1 = gameBarrier.gameWorld.mapCells[gameBarrier.currentMap][charRightCol][charTopRow];
                  cellNum2 = gameBarrier.gameWorld.mapCells[gameBarrier.currentMap][charRightCol][charBottomRow];
                  if(gameBarrier.gameWorld.cell[cellNum1].collision == true || gameBarrier.gameWorld.cell[cellNum2].collision == true){
                      character.collisionOn = true;
                  }
              } else {
                  character.collisionOn = true;
                  return true;
              }
              break;
          default:
              if(character.getX()>0 && character.getX()<gameBarrier.maxScreenCol && character.getY()>0 && character.getY()<gameBarrier.maxScreenRow){
                  cellNum = gameBarrier.gameWorld.mapCells[gameBarrier.currentMap][(character.getX()-gameBarrier.cellSize)/gameBarrier.cellSize][(character.getY()-gameBarrier.cellSize)/gameBarrier.cellSize];
                  if (gameBarrier.gameWorld.cell[cellNum].collision) {
                      character.collisionOn = true;
                      return true;
                  }
                  else {
                      character.collisionOn = false;
                      return false;
                  }
              }
      }
      return false;
  }
}

