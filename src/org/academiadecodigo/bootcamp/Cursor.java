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
    private TextFile textFile;

    private Game game;

    public Cursor(int x, int y, Game game) {
        cursor = new Rectangle(x, y, Cell.CELL_SIZE, Cell.CELL_SIZE);
        cursor.draw();

        this.game = game;
        grid = new Grid();
        keyboardInit();
    }

    public void setCursorPainted() {
        cursor.setColor(Color.CYAN);
        cursor.fill();
    }

    public void setCursorPaintedMagenta() {
        cursor.setColor(Color.MAGENTA);
        cursor.fill();
    }

    public void makeRectanglePainted() {
        int x = cursor.getX();
        int y = cursor.getY();

        int col = ((x - 10) / 25);
        int row = ((y - 10) / 25);

        Cell currentCell = Game.cellsBoard[col][row];
        currentCell.setCellPainted(currentCell, this);
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

        KeyboardEvent paintPressed = new KeyboardEvent();
        paintPressed.setKey(KeyboardEvent.KEY_SPACE);
        paintPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent savedPressed = new KeyboardEvent();
        savedPressed.setKey(KeyboardEvent.KEY_S);
        savedPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent loadPressed = new KeyboardEvent();
        loadPressed.setKey(KeyboardEvent.KEY_L);
        loadPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(rightPressed);
        keyboard.addEventListener(leftPressed);
        keyboard.addEventListener(downPressed);
        keyboard.addEventListener(upPressed);
        keyboard.addEventListener(paintPressed);
        keyboard.addEventListener(savedPressed);
        keyboard.addEventListener(loadPressed);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (cursor.getX() < grid.getWidth() - Grid.PADDING - Grid.PADDING) {
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
                cursor.translate(Cell.CELL_SIZE, 0);
                verifyColor();
            }
        }

        if (cursor.getX() > Grid.PADDING) {
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
                cursor.translate(-Cell.CELL_SIZE, 0);
                verifyColor();
            }
        }

        if (cursor.getY() < grid.getHeight() - Grid.PADDING - Grid.PADDING) {
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
                cursor.translate(0, Cell.CELL_SIZE);
                verifyColor();
            }
        }

        if (cursor.getY() > Grid.PADDING) {
            if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
                cursor.translate(0, -Cell.CELL_SIZE);
                verifyColor();
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            makeRectanglePainted();
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            saveTheGame(Game.cellsBoard);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_L) {
            loadTheGame();
        }
    }

    private void loadTheGame() {
        game.loadingGridBoard();
    }

    private void saveTheGame(Cell[][] cellsBoard) {
        textFile = new TextFile();
        textFile.saveGame(cellsBoard);
    }

    private void verifyColor() {
        int x = cursor.getX();
        int y = cursor.getY();
        int col = ((x - 10) / 25);
        int row = ((y - 10) / 25);

        Cell currentCell = Game.cellsBoard[col][row];
        currentCell.verifyIfCellPainted(this);
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
