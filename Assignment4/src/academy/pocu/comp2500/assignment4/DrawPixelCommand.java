package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class DrawPixelCommand implements ICommand {
    private int x;
    private int y;
    private char character;
    private Canvas canvas;
    private boolean isExecuted = false;
    public Canvas getCanvas() {
        return this.canvas;
    }

    public DrawPixelCommand(int x, int y, char character) {
        this.x = x;
        this.y = y;
        this.character = character;
    }
    @Override
    public boolean execute(Canvas canvas) {
        if (isExecuted) {
            return false;
        }
        isExecuted = true;
        this.canvas = canvas;

        this.canvas.drawPixel(this.x, this.y, this.character);
        return true;
    }
    @Override
    public boolean undo() {
        if (isExecuted) {
            this.canvas.drawPixel(this.x, this.y, ' ');
            return true;
        }

        return false;
    }

    @Override
    public boolean redo() {
        if (isExecuted) {
            this.canvas.drawPixel(this.x, this.y, this.character);
            return true;
        }

        return false;
    }
}
