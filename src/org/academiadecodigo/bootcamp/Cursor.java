package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Cursor implements KeyboardHandler {

    private Rectangle cursor;
    private Grid grid;
    private boolean isPainted;

    public Cursor(int x, int y) {
        cursor = new Rectangle(x, y, Cell.CELL_SIZE, Cell.CELL_SIZE);
        cursor.draw();

        grid = new Grid();
        keyboardInit();
    }

    public void setCursorPainted() {
        cursor.setColor(Color.PINK);
        cursor.fill();
    }

    private void keyboardInit() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent rightPressed = new KeyboardEvent();
        rightPressed.setKey(KeyboardEvent.KEY_RIGHT);
        rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftPressed = new KeyboardEvent();
        leftPressed.setKey(KeyboardEvent.KEY_LEFT);
        leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent downPressed = new KeyboardEvent();
        downPressed.setKey(KeyboardEvent.KEY_DOWN);
        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent upPressed = new KeyboardEvent();
        upPressed.setKey(KeyboardEvent.KEY_UP);
        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(rightPressed);
        keyboard.addEventListener(leftPressed);
        keyboard.addEventListener(downPressed);
        keyboard.addEventListener(upPressed);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (cursor.getX() < grid.getWidth() - Grid.PADDING - Grid.PADDING) {
            System.out.println(cursor.getX());
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
                cursor.translate(Cell.CELL_SIZE, 0);
            }
        }

        if (cursor.getX() > Grid.PADDING) {
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
                cursor.translate(- Cell.CELL_SIZE, 0);
            }
        }

        if (cursor.getY() < grid.getHeight() - Grid.PADDING - Grid.PADDING) {
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
                cursor.translate(0, Cell.CELL_SIZE);
            }
        }

        if (cursor.getY() > Grid.PADDING) {
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
                cursor.translate(0, - Cell.CELL_SIZE);
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public void setPainted(boolean painted) {
        isPainted = painted;
    }

    public boolean isPainted() {
        return isPainted;
    }
}
