package com.example.game;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;

public class GameWorld {
  GameEngine gameBarrier;
  Cells[] cell;
  int mapCells [][];

  public GameWorld(GameEngine gameEngine) {
    this.gameBarrier = gameEngine;
    cell = new Cells[10];
    mapCells = new int[gameBarrier.maxScreenCol][gameBarrier.maxScreenRow];
    drawMap("/maps/Map_AQ.txt");
    getCellImage();
    // for (int i = 0; i < cell.length; i++) {
    //   cell[i] = new Cells();
    // }
  }

  public void getCellImage(){
    try{
      cell[0] =  new Cells();
      cell[0].image = ImageIO.read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/SFU AQ WALL horizontal-1.png"));

      cell[1] =  new Cells();
      cell[1].image = ImageIO.read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/SFU AQ WALL vertical-1.png"));

      cell[2] =  new Cells();
      cell[2].image = ImageIO.read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/SFU AQ WALL LEFT TOP-1.png"));

      cell[3] =  new Cells();
      cell[3].image = ImageIO.read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/SFU AQ WALL RIGHT TOP-1.png"));

      cell[4] =  new Cells();
      cell[4].image = ImageIO.read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/SFU AQ WALL LEFT BOTTOM-1.png"));

      cell[5] =  new Cells();
      cell[5].image = ImageIO.read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/SFU AQ WALL RIGHT BOTTOM-1.png"));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void drawMap(String filePath){
    try{
      InputStream is = getClass().getResourceAsStream(filePath);
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      int col = 0;
      int row = 0;
      while(col< gameBarrier.maxScreenCol && row< gameBarrier.maxScreenRow){
        String line = br.readLine();
        while(col<gameBarrier.maxScreenCol){
          String numbers[] = line.split(" ");
          int num = Integer.parseInt(numbers[col]);
          mapCells[col][row] = num;
          col++;
        }
        if(col == gameBarrier.maxScreenCol){
          col = 0;
          row++;
        }
      }
      br.close();
    } catch(Exception e){
      e.printStackTrace();
    }
  }
  public void draw(Graphics2D g2d, int cellSize) {
    int col = 0;
    int row = 0;
    int x = 0;
    int y = 0;
    while(col< gameBarrier.maxScreenCol && row< gameBarrier.maxScreenRow){
      int cellNum = mapCells[col][row];
      g2d.drawImage(cell[cellNum].image, x, y, cellSize, cellSize, null);
      col++;
      x+= gameBarrier.cellSize;
      if(col == gameBarrier.maxScreenCol){
        col = 0;
        x =0;
        row++;
        y+= gameBarrier.cellSize;
      }
    }
  }
}