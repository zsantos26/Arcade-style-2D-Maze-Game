package com.example.game;

// import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import com.example.characters.StaticRewards;

import java.awt.Graphics2D;

public class LevelOne {
  GameEngine gameBarrier;
  Cells[] cell;
  public int mapCells [][];
  ArrayList<StaticRewards> staticRewardsLocations = new ArrayList<StaticRewards>();

  public LevelOne(GameEngine gameEngine) {
    this.gameBarrier = gameEngine;
    cell = new Cells[40];
    mapCells = new int[gameBarrier.maxScreenCol][gameBarrier.maxScreenRow];
    drawMap("/maps/Map_AQ.txt");
    getCellImage();
  }

  public void getCellImage(){
    try{
      cell[0] =  new Cells();
      cell[0].image = ImageIO.read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/SFU_top.png"));
      cell[0].collision = true;

      cell[1] =  new Cells();
      cell[1].image = ImageIO.read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/SFU_LEFT.png"));
      cell[1].collision = true;

      cell[2] =  new Cells();
      cell[2].image = ImageIO.read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/sfu_left_top.png"));
      cell[2].collision = true;

      cell[3] =  new Cells();
      cell[3].image = ImageIO.read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/sfu_right_top.png"));
      cell[3].collision = true;

      cell[4] =  new Cells();
      cell[4].image = ImageIO.read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/SFU AQ WALL LEFT BOTTOM-1.png"));
      cell[4].collision = true;

      cell[5] =  new Cells();
      cell[5].image = ImageIO.read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/SFU AQ WALL RIGHT BOTTOM-1.png"));
      cell[5].collision = true;

      cell[6] =  new Cells(); //water
      cell[6].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water-1.png"));
      cell[6].collision = true;

      cell[7] =  new Cells(); //tree
      cell[7].image = ImageIO.read(getClass().getResourceAsStream("/images/background/tree-1.png"));
      cell[7].collision = true;

      cell[8] =  new Cells(); //grass
      cell[8].image = ImageIO.read(getClass().getResourceAsStream("/images/background/grass-1.png"));

      cell[9] =  new Cells(); //road
      cell[9].image = ImageIO.read(getClass().getResourceAsStream("/images/background/road.png"));

      cell[10] = new Cells(); //bush
      cell[10].image = ImageIO.read(getClass().getResourceAsStream("/images/background/bush-1.png"));
      cell[10].collision = true;

      cell[11] = new Cells(); //road_left
      cell[11].image = ImageIO.read(getClass().getResourceAsStream("/images/background/floorgrassleft-1.png.png"));

      cell[12] = new Cells(); //road_right
      cell[12].image = ImageIO.read(getClass().getResourceAsStream("/images/background/floorgrassright-1.png.png"));

      cell[13] = new Cells(); //water_left_up
      cell[13].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_left_up.png"));
      cell[13].collision = true;
//
      cell[14] = new Cells(); //water_up
      cell[14].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_up.png"));
      cell[14].collision = true;
//
      cell[15] = new Cells(); //water_right_up
      cell[15].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_right_up.png"));
      cell[15].collision = true;

      cell[16] = new Cells(); //water_left
      cell[16].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_left.png"));
      cell[16].collision = true;

      cell[17] = new Cells(); //water_left_down
      cell[17].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_left_down.png"));
      cell[17].collision = true;

      cell[18] = new Cells(); //water_down
      cell[18].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_down.png"));
      cell[18].collision = true;
//
      cell[19] = new Cells(); //water_right_down
      cell[19].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_right_down.png"));
      cell[19].collision = true;

      cell[20] = new Cells(); //water_right
      cell[20].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_right.png"));
      cell[20].collision = true;

      cell[21] = new Cells(); //road water left
      cell[21].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_left.png"));

      cell[22] = new Cells(); //road water right
      cell[22].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_right.png"));

      cell[23] = new Cells(); //road water left
      cell[23].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_road_left_down.png"));

      cell[24] = new Cells(); //road water right
      cell[24].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_road_right_down.png"));

      cell[25] = new Cells(); //road water left
      cell[25].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_road_right_up.png"));

      cell[26] = new Cells(); //road water right
      cell[26].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_road_left_up.png"));

      cell[27] = new Cells(); //road water right
      cell[27].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_left_down.png"));

      cell[28] = new Cells(); //road water right
      cell[28].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_down.png"));

      cell[29] = new Cells(); //road water right
      cell[29].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_left_up.png"));

      cell[30] = new Cells(); //road water left
      cell[30].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_right_down.png"));

      cell[31] = new Cells(); //road water right
      cell[31].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_road_right_down.png"));

      cell[32] = new Cells(); //road water left
      cell[32].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_right_up.png"));

      cell[33] = new Cells(); //road water right
      cell[33].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_right_up_2.png"));

      cell[34] = new Cells(); //road water right
      cell[34].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_right_down_2.png"));

      cell[35] = new Cells(); //road water right
      cell[35].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_right_down_3.png"));

      cell[36] = new Cells(); //road water right
      cell[36].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_right_up_3.png"));

      cell[37] = new Cells(); //road water right
      cell[37].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_road_ground.png"));

      cell[38] = new Cells(); //road water right
      cell[38].image = ImageIO.read(getClass().getResourceAsStream("/images/background/avocado.png"));
      cell[38].collision = true;

      cell[39] =  new Cells();
      cell[39].image = ImageIO.read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/SFU_right.png"));
      cell[39].collision = true;

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