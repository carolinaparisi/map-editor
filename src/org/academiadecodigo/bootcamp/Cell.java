package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    public static final int CELL_SIZE = 25;
    private int x;
    private int y;
    private Rectangle cell;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;

        cell = new Rectangle(x, y, CELL_SIZE, CELL_SIZE);
        cell.draw();
    }
}
