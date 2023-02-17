package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    public static final int PADDING = 10;
    private int width;
    private int height;
    private Rectangle grid;
    private int cols = 16;
    private int rows = 16;

    public Grid() {
        this.width = cols * Cell.CELL_SIZE;
        this.height = rows * Cell.CELL_SIZE;

        grid = new Rectangle(PADDING, PADDING, this.width, this.height);

        grid.draw();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }
}
