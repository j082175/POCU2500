package academy.pocu.comp2500.assignment4;

public class DrawPixelCommand implements ICommand {
    private int x;
    private int y;
    private char character;
    private Canvas canvas;
    private char backupPixel = 0;
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
            this.canvas.drawPixel(this.x, this.y, this.character);
            this.backupPixel = this.canvas.getPixel(this.x, this.y);
            return true;
        }

        return false;
    }
    @Override
    public boolean undo() {
        if (isExecuted) {
            if (this.backupPixel != 0) {
                this.backupPixel = 0;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean redo() {
        if (isExecuted) {
            if (this.backupPixel == 0) {
                this.backupPixel = this.canvas.getPixel(this.x, this.y);
                return true;
            }
        }
        return false;
    }
}
