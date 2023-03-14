package com.example.game;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
public class LevelTwo {
    GameEngine gameBarrier;
    Cells[] cell;
    public int mapCells [][];

    public Leveltwo(GameEngine gameEngine) {
        this.gameBarrier = gameEngine;
        cell = new Cells[40];
        mapCells = new int[gameBarrier.maxScreenCol][gameBarrier.maxScreenRow];
        drawMap("/maps/Map_Class.txt");
        getCellImage();
    }
    public void getCellImage(){
        try{
            cell[0] =  new Cells();
            cell[0].image = ImageIO.read(getClass().getResourceAsStream("/images/class/class_floor.png"));

            cell[1] =  new Cells();
            cell[1].image = ImageIO.read(getClass().getResourceAsStream("/images/class/wall.png"));

            cell[2] =  new Cells();
            cell[2].image = ImageIO.read(getClass().getResourceAsStream("/images/class/wall_bottom.png"));

            cell[3] =  new Cells();
            cell[3].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_top.png"));

            cell[4] =  new Cells();
            cell[4].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_bot.png"));

            cell[5] =  new Cells();
            cell[5].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_left_top.png"));

            cell[6] =  new Cells(); //water
            cell[6].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_right_top.png"));

            cell[7] =  new Cells(); //tree
            cell[7].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_right_bot.png"));

            cell[8] =  new Cells(); //grass
            cell[8].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_left_bot.png"));

            cell[9] =  new Cells(); //road
            cell[9].image = ImageIO.read(getClass().getResourceAsStream("/images/class/table_left.png"));

            cell[10] = new Cells(); //bush
            cell[10].image = ImageIO.read(getClass().getResourceAsStream("/images/class/table_right.png"));

            cell[11] = new Cells(); //road_left
            cell[11].image = ImageIO.read(getClass().getResourceAsStream("/images/class/chair_left.png"));

            cell[12] = new Cells(); //road_right
            cell[12].image = ImageIO.read(getClass().getResourceAsStream("/images/class/chair_right.png"));

            cell[13] = new Cells(); //water_left_up
            cell[13].image = ImageIO.read(getClass().getResourceAsStream("/images/class/garbage_bin.png"));
//
            cell[14] = new Cells(); //water_up
            cell[14].image = ImageIO.read(getClass().getResourceAsStream("/images/class/board_paper.png"));
//
            cell[15] = new Cells(); //water_right_up
            cell[15].image = ImageIO.read(getClass().getResourceAsStream("/images/class/bigtable_top.png"));

            cell[16] = new Cells(); //water_left
            cell[16].image = ImageIO.read(getClass().getResourceAsStream("/images/class/bigtable_bot.png"));

            cell[17] = new Cells(); //water_left_down
            cell[17].image = ImageIO.read(getClass().getResourceAsStream("/images/class/bigtable_left_top.png"));

            cell[18] = new Cells(); //water_down
            cell[18].image = ImageIO.read(getClass().getResourceAsStream("/images/class/bigtable_right_top.png"));
//
            cell[19] = new Cells(); //water_right_down
            cell[19].image = ImageIO.read(getClass().getResourceAsStream("/images/class/bigtable_right_bot.png"));
//
            cell[20] = new Cells(); //water_right
            cell[20].image = ImageIO.read(getClass().getResourceAsStream("/images/class/bigtable_left_bot.png"));

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


