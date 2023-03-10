package com.example.mygame.model;

public class GameModel {
    private Cells[][] cells;

    public GameModel() {
        cells = new Cells[48][48];
        int cellWidth = 20;
        int cellHeight = 20;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cells(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
            }
        }
        MainCharacter mainCharacter = new MainCharacter(0,0,20,20,);//This could be randomly spawn so we can do it so that it is not in the same place every time
        cells[0][0].setGameObject(mainCharacter);
        // ...
    }

    public Cells[][] getCells() {
        return cells;
    }
}
