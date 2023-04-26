package org.academiadecodigo.bootcamp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Game {

    private Grid grid;
    private Cursor cursor;
    public static Cell[][] cellsBoard;
    private int cols;
    private int rows;
    private FileReader fileReader;


    public Game() {
        grid = new Grid();

        this.cols = grid.getCols();
        this.rows = grid.getRows();

        creatingGrid();
    }

    private void creatingGrid() {

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

    public void creatingGridSaved() {
        int[][] intCellsBoard = new int[Grid.rows + 1][Grid.cols + 1];

        try {
            fileReader = new FileReader("resources/saved.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            System.out.println(bufferedReader.readLine());
            while (bufferedReader.readLine() != null) {
                for (int i = 0; i < Grid.rows - 2; i++) {
                        System.out.println(bufferedReader.readLine());
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() {
        cursor = new Cursor(Grid.PADDING, Grid.PADDING);
        cursor.setCursorPainted();
    }
}
