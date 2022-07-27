package academy.pocu.comp2500.assignment4;

public class DrawPixelCommand implements ICommand {
    private int x;
    private int y;
    private char character;
    private Canvas canvas;

    private boolean isExecuted = false;

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
        canvas.drawPixel(this.x, this.y, this.character);
        return true;
    }

    @Override
    public boolean undo() {
        canvas.drawPixel(this.x, this.y, ' ');

        return true;
    }

    @Override
    public boolean redo() {
        canvas.drawPixel(this.x, this.y, this.character);
        return true;
    }
}
