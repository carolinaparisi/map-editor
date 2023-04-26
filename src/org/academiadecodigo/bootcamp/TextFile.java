package org.academiadecodigo.bootcamp;

import java.io.*;

public class TextFile {

    private FileWriter fileWriter;

    public void createFile(int[][] intCellsBoard) {
        File file = new File("resources/saved.txt");
        try {
            fileWriter = new FileWriter(file);

            for (int i = 0; i < Grid.rows; i++) {
                for (int j = 0; j < Grid.cols; j++) {
                    if (intCellsBoard[i][j] == 1) {
                        fileWriter.write("1" + " ");
                        continue;
                    }
                    fileWriter.write("0" + " ");
                }
                fileWriter.write("\n");
            }

            fileWriter.close();

            System.out.println("Text saved");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveGame(Cell[][] cellsBoard) {
        int[][] intCellsBoard = new int[Grid.rows + 1][Grid.cols + 1];
        for (int i = 0; i < Grid.rows; i++) {
            for (int j = 0; j < Grid.cols; j++) {
                if (cellsBoard[i][j].isPainted()) {
                    intCellsBoard[i][j] = 1;
                    continue;
                }
                intCellsBoard[i][j] = 0;
            }
        }

        createFile(intCellsBoard);
    }
}
