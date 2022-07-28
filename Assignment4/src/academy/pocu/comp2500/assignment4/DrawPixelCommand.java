package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class DrawPixelCommand implements ICommand {
    private int x;
    private int y;
    private char character;
    private Canvas canvas;
    private ArrayList<Canvas> canvasArrayList = new ArrayList<>();
    private int index = 0;
    private boolean isExecuted = false;
/*    public Canvas getCanvas() {
        return this.canvas;
    }*/

    public DrawPixelCommand(int x, int y, char character) {
        this.x = x;
        this.y = y;
        this.character = character;
        //this.canvas.drawPixel(this.x, this.y, this.character);
    }
    @Override
    public boolean execute(Canvas canvas) {
        if (this.x >= 0 && this.y >= 0 && this.x < canvas.getWidth() && this.y < canvas.getHeight()) {
            if (isExecuted) {
                return false;
            }
            isExecuted = true;
            this.canvas = canvas;
            this.canvasArrayList.add(this.canvas);
            this.canvas.drawPixel(this.x, this.y, this.character);
            this.canvasArrayList.add(this.canvas);
            this.index++;
            return true;
        }

        return false;
    }
    @Override
    public boolean undo() {
        if (isExecuted) {
            if (this.index > 0) {
                this.index--;
                this.canvas = this.canvasArrayList.get(this.index);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean redo() {
        if (isExecuted) {
            if (this.index == 0 && this.canvasArrayList.size() != 0) {
                this.index++;
                this.canvas = this.canvasArrayList.get(this.index);
                return true;
            }
        }
        return false;
    }
}
