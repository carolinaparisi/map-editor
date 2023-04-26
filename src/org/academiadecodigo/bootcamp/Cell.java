package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    public static final int CELL_SIZE = 25;

    private int number;
    private int x;
    private int y;
    private int col;
    private int row;
    private Rectangle cell;
    private boolean isPainted;

    public Cell(int col, int row) {

        this.col = col;
        this.row = row;

        this.x = this.col * CELL_SIZE;
        this.y = this.row * CELL_SIZE;

        cell = new Rectangle(this.x + Grid.PADDING, this.y + Grid.PADDING, CELL_SIZE, CELL_SIZE);
        cell.draw();
    }

    public void setColorCell(Cursor cursor) {
        if (!isPainted) {
            setPainted(true);
            this.cell.setColor(Color.PINK);
            this.cell.fill();

            cursor.setCursorPaintedMagenta();
            return;
        }

        setPainted(false);
        this.cell.setColor(Color.BLACK);
        this.cell.draw();
        cursor.setCursorPainted();
    }

    public void setCellPainted(Cell currentCell, Cursor cursor) {
        currentCell.setColorCell(cursor);
    }

    public void setPainted(boolean painted) {
        isPainted = painted;
    }

    public boolean isPainted() {
        return isPainted;
    }

    public void verifyIfCellPainted(Cursor cursor) {
        if (this.isPainted) {
            cursor.setCursorPaintedMagenta();
            return;
        }

        cursor.setCursorPainted();
    }
}
