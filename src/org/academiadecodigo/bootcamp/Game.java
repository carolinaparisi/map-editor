package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    private Grid grid;
    private Cursor cursor;


    public Game() {
        grid = new Grid();
        creatingGrid();
    }

    private void creatingGrid() {
        // i = X;
        // j = Y;

        int numberCellCol = grid.getWidth() / Cell.CELL_SIZE;
        int numberCellRow = grid.getHeight() / Cell.CELL_SIZE;
        int initialX = Grid.PADDING;
        int initialY = Grid.PADDING;

        for (int i = 0; i < numberCellCol; i++) {
            for (int j = 0; j < numberCellRow; j++) {
                new Cell(initialX, initialY);
                initialX += Cell.CELL_SIZE;
            }
            initialX = Grid.PADDING;
            initialY += Cell.CELL_SIZE;
        }
    }

    public void start() {
        cursor = new Cursor(Grid.PADDING, Grid.PADDING);
        cursor.setCursorPainted();
    }
}
