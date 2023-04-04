package com.example.game;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

import com.example.characters.MainCharacter;

public class GameWorld {
  GameEngine gameBarrier;
  Cells[] cell;
  public int mapCells[][];
  public int map = 0;

  public GameWorld(GameEngine gameEngine) {
    this.gameBarrier = gameEngine;
    cell = new Cells[70];
    mapCells = new int[gameBarrier.maxScreenCol][gameBarrier.maxScreenRow];
    String map1 = "/maps/Map_Class.txt";
    drawMap(map1);
    getCellImage();
  }

  public void changeMap() {
    map = 1;
    String map2 = "/maps/Map_AQ.txt";
    drawMap(map2);
    getCellImage();

  }

  public boolean updateCellProperties(MainCharacter mainChar) {
    int dx = mainChar.getX();
    int dy = mainChar.getY();

    // check if enemy is already adjacent to the main character
    if (mainChar.getScore() > 500) {
      cell[1].collision = false;
      cell[1].portal = true;
      System.out.println("Portal is open");
      System.out.println("dx: " + dx + " dy: " + dy);
      if (map == 0 && dx == 912 && dy == 864) {
        return true;
      } else if (mainChar.getScore() > 1000) {
        cell[61].collision = false;
        cell[61].portal = true;
        if (map == 1 && dx == 432 && dy == 0) {
          map = 1;
          gameBarrier.victory();
        }
        return true;
      }
      return false;
    } else {
      cell[1].collision = true;
      cell[1].portal = false;
      return false;
    }
  }

  public void getCellImage() {
    try {
      // MAP AQ
      cell[0] = new Cells();// AQ WALL
      cell[0].image = ImageIO.read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/SFU_top.png"));
      cell[0].collision = true;

      cell[1] = new Cells();// PORTAL
      cell[1].image = ImageIO.read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/SFU_Portal.png"));
      cell[1].collision = true;
      cell[1].portal = false;

      cell[2] = new Cells(); // grass
      cell[2].image = ImageIO.read(getClass().getResourceAsStream("/images/background/grass-1.png"));

      cell[3] = new Cells(); // road
      cell[3].image = ImageIO.read(getClass().getResourceAsStream("/images/background/road.png"));

      cell[4] = new Cells(); // road_left
      cell[4].image = ImageIO.read(getClass().getResourceAsStream("/images/background/floorgrassleft-1.png.png"));

      cell[5] = new Cells(); // road_right
      cell[5].image = ImageIO.read(getClass().getResourceAsStream("/images/background/floorgrassright-1.png.png"));

      cell[6] = new Cells(); // water
      cell[6].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water-1.png"));
      cell[6].collision = true;

      cell[7] = new Cells(); // tree
      cell[7].image = ImageIO.read(getClass().getResourceAsStream("/images/background/tree-1.png"));
      cell[7].collision = true;

      cell[8] = new Cells(); // bush
      cell[8].image = ImageIO.read(getClass().getResourceAsStream("/images/background/bush-1.png"));
      cell[8].collision = true;

      cell[9] = new Cells(); // water_left_up
      cell[9].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_left_up.png"));
      cell[9].collision = true;

      cell[10] = new Cells(); // water_up
      cell[10].image = ImageIO.read(getClass().getResourceAsStream("/images/background/water_up.png"));
      cell[10].collision = true;

      cell[11] = new Cells(); // road water left up
      cell[11].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_left_up_2.png"));

      cell[12] = new Cells(); // road water left down
      cell[12].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_left_down_2.png"));

      cell[13] = new Cells(); // road water right up
      cell[13].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_right_up_2.png"));

      cell[14] = new Cells(); // road water right down
      cell[14].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_right_down_2.png"));

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

      cell[23] = new Cells(); // road water right up
      cell[23].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_right_up.png"));

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

      cell[28] = new Cells(); // road water right_down
      cell[28].image = ImageIO
          .read(getClass().getResourceAsStream("/images/background/water_road_ground_right_down.png"));

      cell[29] = new Cells(); // road water left up
      cell[29].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_left_up.png"));

      cell[30] = new Cells(); // road water left
      cell[30].image = ImageIO.read(getClass().getResourceAsStream("/images/background/roadwater_right_down.png"));

      // MAP ROOM
      cell[40] = new Cells(); // class_floor
      cell[40].image = ImageIO.read(getClass().getResourceAsStream("/images/class/class_floor.png"));

      cell[41] = new Cells(); // wall
      cell[41].image = ImageIO.read(getClass().getResourceAsStream("/images/class/wall.png"));
      cell[41].collision = true;

      cell[42] = new Cells(); // wall_bottom
      cell[42].image = ImageIO.read(getClass().getResourceAsStream("/images/class/wall_bottom.png"));
      cell[42].collision = true;

      cell[43] = new Cells(); // board top
      cell[43].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_top.png"));
      cell[43].collision = true;

      cell[44] = new Cells(); // board bot
      cell[44].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_bot.png"));
      cell[44].collision = true;

      cell[45] = new Cells(); // board left top
      cell[45].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_left_top.png"));
      cell[45].collision = true;

      cell[46] = new Cells(); // board right top
      cell[46].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_right_top.png"));
      cell[46].collision = true;

      cell[47] = new Cells(); // board right bot
      cell[47].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_right_bot.png"));
      cell[47].collision = true;

      cell[48] = new Cells(); // board left bot
      cell[48].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_left_bot.png"));
      cell[48].collision = true;

      cell[49] = new Cells(); // table left
      cell[49].image = ImageIO.read(getClass().getResourceAsStream("/images/class/table_left.png"));
      cell[49].collision = true;

      cell[50] = new Cells(); // table right
      cell[50].image = ImageIO.read(getClass().getResourceAsStream("/images/class/table_right.png"));
      cell[50].collision = true;

      cell[51] = new Cells(); // chair left
      cell[51].image = ImageIO.read(getClass().getResourceAsStream("/images/class/chair_left.png"));
      cell[51].collision = true;

      cell[52] = new Cells(); // chair right
      cell[52].image = ImageIO.read(getClass().getResourceAsStream("/images/class/chair_right.png"));
      cell[52].collision = true;

      cell[53] = new Cells(); // garbage bin
      cell[53].image = ImageIO.read(getClass().getResourceAsStream("/images/class/garbage_bin.png"));
      cell[53].collision = true;

      cell[54] = new Cells(); // board paper
      cell[54].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_paper.png"));
      cell[54].collision = true;
      //
      cell[55] = new Cells(); // bigtable top
      cell[55].image = ImageIO.read(getClass().getResourceAsStream("/images/class/bigtable_top.png"));
      cell[55].collision = true;

      cell[56] = new Cells(); // bigtable bot
      cell[56].image = ImageIO.read(getClass().getResourceAsStream("/images/class/bigtable_bot.png"));
      cell[56].collision = true;

      cell[57] = new Cells(); // bigtable left top
      cell[57].image = ImageIO.read(getClass().getResourceAsStream("/images/class/bigtable_left_top.png"));
      cell[57].collision = true;

      cell[58] = new Cells(); // bigtable right top
      cell[58].image = ImageIO.read(getClass().getResourceAsStream("/images/class/bigtable_right_top.png"));
      cell[58].collision = true;

      cell[59] = new Cells(); // bigtable right bot
      cell[59].image = ImageIO.read(getClass().getResourceAsStream("/images/class/bigtable_right_bot.png"));
      cell[59].collision = true;

      cell[60] = new Cells(); // bigtable left bot
      cell[60].image = ImageIO.read(getClass().getResourceAsStream("/images/class/bigtable_left_bot.png"));
      cell[60].collision = true;

      cell[61] = new Cells(); // bigtable left bot
      cell[61].image = ImageIO.read(getClass().getResourceAsStream("/images/AQ_OUTTERWALL/SFU_Portal.png"));
      cell[61].collision = true;
      cell[61].portal = false;

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void drawMap(String filePath) {
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
          mapCells[col][row] = num;
          col++;
        }
        String[] numbers = line.trim().split("\\s+");
        for (col = 0; col < Math.min(gameBarrier.maxScreenCol, numbers.length); col++) {
          mapCells[col][row] = Integer.parseInt(numbers[col]);
        }
      }
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
      int cellNum = mapCells[col][row];
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