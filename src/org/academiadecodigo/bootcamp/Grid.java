package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    public static final int PADDING = 10;
    private int width;
    private int height;
    private Rectangle grid;

    public Grid() {
        this.width = 400;
        this.height = 400;

        grid = new Rectangle(PADDING, PADDING, this.width, this.height);

        grid.draw();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
