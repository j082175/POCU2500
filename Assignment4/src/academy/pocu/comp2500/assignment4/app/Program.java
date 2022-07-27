package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.*;

public class Program {

    public static void main(String[] args) {
        Canvas canvas = new Canvas(10, 10);
        CommandHistoryManager commandHistoryManager = new CommandHistoryManager(canvas);

        // 반복
        DrawPixelCommand drawPixelCommand = new DrawPixelCommand(3, 3, '?');
        commandHistoryManager.execute(drawPixelCommand);
        System.out.println(canvas.getDrawing());
        if (commandHistoryManager.canUndo()) {
            commandHistoryManager.undo();
        }
        System.out.println(canvas.getDrawing());
        if (commandHistoryManager.canRedo()) {
            commandHistoryManager.redo();
        }
        System.out.println(canvas.getDrawing());
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
