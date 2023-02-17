package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    public static final int CELL_SIZE = 25;
    private int x;
    private int y;
    private int col;
    private int row;
    private Rectangle cell;

    public Cell(int col, int row) {
        this.col = col;
        this.row = row;

        this.x = this.col * CELL_SIZE;
        this.y = this.row * CELL_SIZE;

        cell = new Rectangle(this.x + Grid.PADDING, this.y + Grid.PADDING, CELL_SIZE, CELL_SIZE);
        cell.draw();
    }

    public Rectangle getCell() {
        return cell;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
