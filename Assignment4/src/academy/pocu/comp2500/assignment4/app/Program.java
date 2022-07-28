package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.*;

public class Program {

    public static void main(String[] args) {
        Canvas canvas = new Canvas(2, 3);
        canvas.drawPixel(0, 0, '*');
        canvas.drawPixel(1, 2, '$');
        canvas.drawPixel(0, 1, '&');
        System.out.println(canvas.getDrawing());

/*        CommandHistoryManager commandHistoryManager = new CommandHistoryManager(canvas);

        // 반복
        DrawPixelCommand d1 = new DrawPixelCommand(3, 3, '?');
        commandHistoryManager.execute(d1);
        System.out.println(canvas.getDrawing());
        commandHistoryManager.undo();
        System.out.println(canvas.getDrawing());
        commandHistoryManager.redo();
        System.out.println(canvas.getDrawing());*/
        // 반복





        /*// 반복
        IncreasePixelCommand increasePixelCommand = new IncreasePixelCommand();
        commandHistoryManager.execute(increasePixelCommand);
        if (commandHistoryManager.canUndo()) {
            commandHistoryManager.undo();
        }
        if (commandHistoryManager.canRedo()) {
            commandHistoryManager.redo();
        }
        // 반복

        // 반복
        DecreasePixelCommand decreasePixelCommand = new DecreasePixelCommand();
        commandHistoryManager.execute(decreasePixelCommand);
        if (commandHistoryManager.canUndo()) {
            commandHistoryManager.undo();
        }
        if (commandHistoryManager.canRedo()) {
            commandHistoryManager.redo();
        }
        // 반복

        // 반복
        ToUpperCommand toUpperCommand = new ToUpperCommand();
        commandHistoryManager.execute(toUpperCommand);
        if (commandHistoryManager.canUndo()) {
            commandHistoryManager.undo();
        }
        if (commandHistoryManager.canRedo()) {
            commandHistoryManager.redo();
        }
        // 반복

        // 반복
        ToLowerCommand toLowerCommand = new ToLowerCommand();
        commandHistoryManager.execute(toLowerCommand);
        if (commandHistoryManager.canUndo()) {
            commandHistoryManager.undo();
        }
        if (commandHistoryManager.canRedo()) {
            commandHistoryManager.redo();
        }
        // 반복

        // 반복
        FillHorizontalLineCommand fillHorizontalLineCommand = new FillHorizontalLineCommand();
        commandHistoryManager.execute(fillHorizontalLineCommand);
        if (commandHistoryManager.canUndo()) {
            commandHistoryManager.undo();
        }
        if (commandHistoryManager.canRedo()) {
            commandHistoryManager.redo();
        }
        // 반복

        // 반복
        FillVerticalLineCommand fillVerticalLineCommand = new FillVerticalLineCommand();
        commandHistoryManager.execute(fillVerticalLineCommand);
        if (commandHistoryManager.canUndo()) {
            commandHistoryManager.undo();
        }
        if (commandHistoryManager.canRedo()) {
            commandHistoryManager.redo();
        }
        // 반복

        // 반복
        ClearCommand clearCommand = new ClearCommand();
        commandHistoryManager.execute(clearCommand);
        if (commandHistoryManager.canUndo()) {
            commandHistoryManager.undo();
        }
        if (commandHistoryManager.canRedo()) {
            commandHistoryManager.redo();
        }
        // 반복*/
    }
}
