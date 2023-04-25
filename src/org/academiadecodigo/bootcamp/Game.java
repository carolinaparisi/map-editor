package org.academiadecodigo.bootcamp;

public class Game {

    private Grid grid;
    private Cursor cursor;
    public static Cell[][] cellsBoard;
    private int cols;
    private int rows;


    public Game() {

        TextFile textFile = new TextFile();
        textFile.createFile();

        grid = new Grid();

        this.cols = grid.getCols();
        this.rows = grid.getRows();

        creatingGrid();
    }

    private void creatingGrid() {
        // i = X;
        // j = Y;

        int numberCellCol = grid.getWidth() / Cell.CELL_SIZE;
        int numberCellRow = grid.getHeight() / Cell.CELL_SIZE;
        cellsBoard = new Cell[numberCellCol][numberCellRow];

        int initialCol = 0;
        int initialRow = 0;

        for (int i = 0; i < this.cols; i++) {
            for (int j = 0; j < this.rows; j++) {
                Cell currentCell = new Cell(initialCol, initialRow);
                cellsBoard[initialCol][initialRow] = currentCell;
                initialCol += 1;
            }
            initialCol = 0;
            initialRow += 1;
        }
    }

    public void start() {
        cursor = new Cursor(Grid.PADDING, Grid.PADDING);
        cursor.setCursorPainted();
    }
}
