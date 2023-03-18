package com.example.game;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

public class GameWorld {
  GameEngine gameBarrier;
  Cells[] cell;
  public int mapCells[][][];
  public int map;

  public GameWorld(GameEngine gameEngine) {
    this.gameBarrier = gameEngine;
    cell = new Cells[70];
    mapCells = new int[gameBarrier.maxMap][gameBarrier.maxScreenCol][gameBarrier.maxScreenRow];
    String map1 = "/maps/Map_AQ.txt";
    String map2 = "/maps/Map_Class.txt";
    drawMap(map1, 0);
    getCellImage();
    if (map == 1) {
      drawMap(map2, 0);
      getCellImage();
    }
  }

  public void getCellImage() {
    try {
      // MAP AQ
      cell[0] = new Cells();
      cell[0].image = ImageIO.read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/SFU_top.png"));
      cell[0].collision = true;

      cell[1] = new Cells();
      cell[1].image = ImageIO.read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/SFU_Portal.png"));
      cell[1].collision = true;
      cell[1].portal = false;
      if (gameBarrier.mainChar.score > 3000) {
        cell[1].collision = false;
        cell[1].portal = true;
        map = 1;
      }

      cell[2] = new Cells(); // road water right
      cell[2].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_left_up_2.png"));

      cell[3] = new Cells(); // road water right
      cell[3].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_left_down_2.png"));

      cell[4] = new Cells();
      cell[4].image = ImageIO
          .read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/SFU AQ WALL LEFT BOTTOM-1.png"));
      cell[4].collision = true;

      cell[5] = new Cells();
      cell[5].image = ImageIO
          .read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/SFU AQ WALL RIGHT BOTTOM-1.png"));
      cell[5].collision = true;

      cell[6] = new Cells(); // water
      cell[6].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water-1.png"));
      cell[6].collision = true;

      cell[7] = new Cells(); // tree
      cell[7].image = ImageIO.read(getClass().getResourceAsStream("/images/background/tree-1.png"));
      cell[7].collision = true;

      cell[8] = new Cells(); // grass
      cell[8].image = ImageIO.read(getClass().getResourceAsStream("/images/background/grass-1.png"));

      cell[9] = new Cells(); // road
      cell[9].image = ImageIO.read(getClass().getResourceAsStream("/images/background/road.png"));

      cell[10] = new Cells(); // bush
      cell[10].image = ImageIO.read(getClass().getResourceAsStream("/images/background/bush-1.png"));
      cell[10].collision = true;

      cell[11] = new Cells(); // road_left
      cell[11].image = ImageIO.read(getClass().getResourceAsStream("/images/background/floorgrassleft-1.png.png"));

      cell[12] = new Cells(); // road_right
      cell[12].image = ImageIO.read(getClass().getResourceAsStream("/images/background/floorgrassright-1.png.png"));

      cell[13] = new Cells(); // water_left_up
      cell[13].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_left_up.png"));
      cell[13].collision = true;
      //
      cell[14] = new Cells(); // water_up
      cell[14].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_up.png"));
      cell[14].collision = true;
      //
      cell[15] = new Cells(); // water_right_up
      cell[15].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_right_up.png"));
      cell[15].collision = true;

      cell[16] = new Cells(); // water_left
      cell[16].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_left.png"));
      cell[16].collision = true;

      cell[17] = new Cells(); // water_left_down
      cell[17].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_left_down.png"));
      cell[17].collision = true;

      cell[18] = new Cells(); // water_down
      cell[18].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_down.png"));
      cell[18].collision = true;
      //
      cell[19] = new Cells(); // water_right_down
      cell[19].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_right_down.png"));
      cell[19].collision = true;

      cell[20] = new Cells(); // water_right
      cell[20].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_right.png"));
      cell[20].collision = true;

      cell[21] = new Cells(); // road water left
      cell[21].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_left.png"));

      cell[22] = new Cells(); // road water right
      cell[22].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_right.png"));

      cell[23] = new Cells(); // road water left
      cell[23].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_road_left_down.png"));

      cell[24] = new Cells(); // water_road_ground_left_down
      cell[24].image = ImageIO
          .read(getClass().getResourceAsStream("/images/background/water_road_ground_left_down.png"));

      cell[25] = new Cells(); // road water left
      cell[25].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_road_ground_left_up.png"));

      cell[26] = new Cells(); // road water right
      cell[26].image = ImageIO
          .read(getClass().getResourceAsStream("/images/background/water_road_ground_right_up.png"));

      cell[27] = new Cells(); // road water right
      cell[27].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_left_down.png"));

      cell[28] = new Cells(); // road water right
      cell[28].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_down.png"));

      cell[29] = new Cells(); // road water left up
      cell[29].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_left_up.png"));

      cell[30] = new Cells(); // road water left
      cell[30].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_right_down.png"));

      cell[31] = new Cells(); // road water right_down
      cell[31].image = ImageIO
          .read(getClass().getResourceAsStream("/images/background/water_road_ground_right_down.png"));

      cell[32] = new Cells(); // road water right up
      cell[32].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_right_up.png"));

      cell[33] = new Cells(); // road water right
      cell[33].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_right_up_2.png"));

      cell[34] = new Cells(); // road water right
      cell[34].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_right_down_2.png"));

      cell[35] = new Cells(); // road water right
      cell[35].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_right_down_3.png"));

      cell[36] = new Cells(); // road water right
      cell[36].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_right_up_3.png"));

      cell[37] = new Cells(); // road water right
      cell[37].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_road_ground.png"));

      cell[38] = new Cells(); // road water right
      cell[38].image = ImageIO.read(getClass().getResourceAsStream("/images/background/avocado.png"));
      cell[38].collision = true;

      cell[39] = new Cells();
      cell[39].image = ImageIO.read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/SFU_right.png"));
      cell[39].collision = true;

      // MAP ROOM
      cell[40] = new Cells();
      cell[40].image = ImageIO.read(getClass().getResourceAsStream("/images/class/class_floor.png"));

      cell[41] = new Cells();
      cell[41].image = ImageIO.read(getClass().getResourceAsStream("/images/class/wall.png"));
      cell[41].collision = true;

      cell[42] = new Cells();
      cell[42].image = ImageIO.read(getClass().getResourceAsStream("/images/class/wall_bottom.png"));

      cell[43] = new Cells();
      cell[43].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_top.png"));

      cell[44] = new Cells();
      cell[44].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_bot.png"));

      cell[45] = new Cells();
      cell[45].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_left_top.png"));

      cell[46] = new Cells(); // water
      cell[46].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_right_top.png"));

      cell[47] = new Cells(); // tree
      cell[47].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_right_bot.png"));

      cell[48] = new Cells(); // grass
      cell[48].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_left_bot.png"));

      cell[49] = new Cells(); // road
      cell[49].image = ImageIO.read(getClass().getResourceAsStream("/images/class/table_left.png"));
      cell[49].collision = true;

      cell[50] = new Cells(); // bush
      cell[50].image = ImageIO.read(getClass().getResourceAsStream("/images/class/table_right.png"));
      cell[50].collision = true;

      cell[51] = new Cells(); // road_left
      cell[51].image = ImageIO.read(getClass().getResourceAsStream("/images/class/chair_left.png"));
      cell[51].collision = true;

      cell[52] = new Cells(); // road_right
      cell[52].image = ImageIO.read(getClass().getResourceAsStream("/images/class/chair_right.png"));
      cell[52].collision = true;

      cell[53] = new Cells(); // water_left_up
      cell[53].image = ImageIO.read(getClass().getResourceAsStream("/images/class/garbage_bin.png"));
      cell[53].collision = true;

      cell[54] = new Cells(); // water_up
      cell[54].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_paper.png"));
      //
      cell[55] = new Cells(); // water_right_up
      cell[55].image = ImageIO.read(getClass().getResourceAsStream("/images/class/bigtable_top.png"));
      cell[55].collision = true;

      cell[56] = new Cells(); // water_left
      cell[56].image = ImageIO.read(getClass().getResourceAsStream("/images/class/bigtable_bot.png"));
      cell[56].collision = true;

      cell[57] = new Cells(); // water_left_down
      cell[57].image = ImageIO.read(getClass().getResourceAsStream("/images/class/bigtable_left_top.png"));
      cell[57].collision = true;

      cell[58] = new Cells(); // water_down
      cell[58].image = ImageIO.read(getClass().getResourceAsStream("/images/class/bigtable_right_top.png"));
      cell[58].collision = true;

      cell[59] = new Cells(); // water_right_down
      cell[59].image = ImageIO.read(getClass().getResourceAsStream("/images/class/bigtable_right_bot.png"));
      cell[59].collision = true;

      cell[60] = new Cells(); // water_right
      cell[60].image = ImageIO.read(getClass().getResourceAsStream("/images/class/bigtable_left_bot.png"));
      cell[60].collision = true;

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void drawMap(String filePath, int map) {
    try {
      InputStream is = getClass().getResourceAsStream(filePath);
      BufferedReader br = new BufferedReader(new InputStreamReader(is));
      int col = 0;
      int row = 0;
      while (col < gameBarrier.maxScreenCol && row < gameBarrier.maxScreenRow) {
        String line = br.readLine();
        while (col < gameBarrier.maxScreenCol) {
          String numbers[] = line.split(" ");
          int num = Integer.parseInt(numbers[col]);
          mapCells[map][col][row] = num;
          col++;
        }
        if (col == gameBarrier.maxScreenCol) {
          col = 0;
          row++;
        }
      }
      br.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void draw(Graphics2D g2d, int cellSize) {
    int col = 0;
    int row = 0;
    int x = 0;
    int y = 0;
    while (col < gameBarrier.maxScreenCol && row < gameBarrier.maxScreenRow) {
      int cellNum = mapCells[gameBarrier.currentMap][col][row];
      g2d.drawImage(cell[cellNum].image, x, y, cellSize, cellSize, null);
      col++;
      x += gameBarrier.cellSize;
      if (col == gameBarrier.maxScreenCol) {
        col = 0;
        x = 0;
        row++;
        y += gameBarrier.cellSize;
      }
    }
  }
}