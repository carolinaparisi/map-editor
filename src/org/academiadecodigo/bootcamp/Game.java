package org.academiadecodigo.bootcamp;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Game {

    private Grid grid;
    private Cursor cursor;
    public static Cell[][] cellsBoard;
    private int cols;
    private int rows;
    private FileReader fileReader;
    private final String FILE_PATH = "resources/saved.txt";


    public Game() {
        grid = new Grid();

        cellsBoard = new Cell[Grid.cols][Grid.rows];
        this.cols = grid.getCols();
        this.rows = grid.getRows();
        creatingGrid();
    }

    private void creatingGrid() {
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
        cursor = new Cursor(Grid.PADDING, Grid.PADDING, this);
        cursor.setCursorPainted();
    }

    public void loadingGridBoard() {
        LinkedList<String> chars = readFile();
        int initialCol = 0;
        int initialRow = 0;
        int initialChar = 0;

        for (int i = 0; i < Grid.cols; i++) {
            for (int j = 0; j < Grid.rows; j++) {
                if (chars.get(initialChar).equals("1")) {
                    cellsBoard[initialRow][initialCol].setColorCell(cursor);
                }
                initialCol += 1;
                initialChar += 1;
            }
            initialCol = 0;
            initialRow += 1;
        }
    }

    private LinkedList<String> readFile() {
        LinkedList<String> chars = new LinkedList<>();

        try {
            fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int c;
            while ((c = bufferedReader.read()) != -1) {
                String character = String.valueOf((char) c);
                if (character.equals("1") || character.equals("0")) {
                    chars.add(character);
                }
            }
            bufferedReader.close();
            System.out.println(chars);
            return chars;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

