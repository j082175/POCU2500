package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.*;
import academy.pocu.comp2500.assignment4.registry.Registry;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {
    void clearCommandTest() {
        Canvas canvas = new Canvas(2,2);

        CommandHistoryManager commandHistoryManager = new CommandHistoryManager(canvas);

        System.out.println(canvas.getDrawing());


    }
    void test3() {
        Canvas canvas = new Canvas(2,2);
        CommandHistoryManager commandHistoryManager = new CommandHistoryManager(canvas);

        System.out.println(canvas.getDrawing());

        DrawPixelCommand d1 = new DrawPixelCommand(0, 0, '!');
        DrawPixelCommand d2 = new DrawPixelCommand(0, 0, '1');
        DrawPixelCommand d3 = new DrawPixelCommand(0, 0, '2');
        DrawPixelCommand d4 = new DrawPixelCommand(0, 0, '3');
        DrawPixelCommand d5 = new DrawPixelCommand(0, 0, '4');

        commandHistoryManager.execute(d1);
        commandHistoryManager.execute(d2);
        commandHistoryManager.execute(d3);
        commandHistoryManager.execute(d4);
        commandHistoryManager.execute(d5);

        System.out.println(canvas.getDrawing());

        /*assert commandHistoryManager.redo() == false;
        assert commandHistoryManager.undo() == true;
        System.out.println(canvas.getDrawing());*/

        if (commandHistoryManager.canUndo()) {
            assert commandHistoryManager.undo() == true;
            System.out.println(canvas.getDrawing());
        }

        if (commandHistoryManager.canRedo())
        assert commandHistoryManager.redo() == true;
        System.out.println(canvas.getDrawing());

        if (commandHistoryManager.canRedo())
        assert commandHistoryManager.redo() == false;
        System.out.println(canvas.getDrawing());

        if (commandHistoryManager.canUndo())
        assert commandHistoryManager.undo() == true;
        System.out.println(canvas.getDrawing());

        if (commandHistoryManager.canUndo())
        assert commandHistoryManager.undo() == true;
        System.out.println(canvas.getDrawing());

        if (commandHistoryManager.canUndo())
        assert commandHistoryManager.undo() == true;
        System.out.println(canvas.getDrawing());

        if (commandHistoryManager.canUndo())
        assert commandHistoryManager.undo() == true;
        System.out.println(canvas.getDrawing());

        if (commandHistoryManager.canUndo())
        assert commandHistoryManager.undo() == true;
        System.out.println(canvas.getDrawing());

        if (commandHistoryManager.canUndo())
        assert commandHistoryManager.undo() == false;
        System.out.println(canvas.getDrawing());

        if (commandHistoryManager.canRedo())
        assert commandHistoryManager.redo() == true;
        System.out.println(canvas.getDrawing());

        if (commandHistoryManager.canRedo())
        assert commandHistoryManager.redo() == true;
        System.out.println(canvas.getDrawing());

        if (commandHistoryManager.canRedo())
        assert commandHistoryManager.redo() == true;
        System.out.println(canvas.getDrawing());

        if (commandHistoryManager.canRedo())
        assert commandHistoryManager.redo() == true;
        System.out.println(canvas.getDrawing());

        if (commandHistoryManager.canRedo())
        assert commandHistoryManager.redo() == true;
        System.out.println(canvas.getDrawing());

        if (commandHistoryManager.canRedo())
        assert commandHistoryManager.redo() == false;
        System.out.println(canvas.getDrawing());
    }
    void kaizer() {
        Canvas canvas = new Canvas(20, 10);
        CommandHistoryManager chm = new CommandHistoryManager(canvas);
        DrawPixelCommand c1 = new DrawPixelCommand(1, 2, '1');
        DrawPixelCommand c2 = new DrawPixelCommand(3, 5, '2');

        assert (chm.execute(c1) == true);
        assert (chm.execute(c2) == true);

        assert (chm.undo() == true);
        assert (chm.redo() == true);

        assert (chm.undo() == true);

        canvas.drawPixel(1, 2, '5');

        assert (chm.undo() == false);
        assert (chm.redo() == true);

    }

    void testDrawPixelCommand2 () {
        Canvas canvas = new Canvas(20, 10);
        CommandHistoryManager chm = new CommandHistoryManager(canvas);
        ArrayList<ICommand> commandList = new ArrayList<>();
        commandList.add(new DrawPixelCommand(1, 2, '3'));
        commandList.add(new FillHorizontalLineCommand(3, 'h'));
        commandList.add(new DecreasePixelCommand(1, 2));
        commandList.add(new IncreasePixelCommand(1, 2));

        commandList.add(new FillVerticalLineCommand(3, 'h'));
        commandList.add(new ToUpperCommand(3, 2));
        commandList.add(new ToLowerCommand(3, 2));
        commandList.add(new ClearCommand());
        for (ICommand command : commandList) {
            assert (chm.execute(command) == true);
            assert (chm.undo() == true);
            assert (chm.redo() == true);
            canvas.drawPixel(9, 9, '5');
            assert (chm.undo() == false);
            canvas.drawPixel(9, 9, ' ');
            assert (chm.undo() == true);
            canvas.drawPixel(9, 9, '5');
            assert (chm.redo() == false);
            canvas.drawPixel(9, 9, ' ');
            assert (chm.redo() == true);
        }

    }
    void testDrawPixelCommand() {
        Canvas canvas = new Canvas(2, 2);

        //canvas.drawPixel(1,1,'1');


        CommandHistoryManager commandHistoryManager = new CommandHistoryManager(canvas);

        // 반복
        DrawPixelCommand d1 = new DrawPixelCommand(0, 0, '0');

        commandHistoryManager.execute(d1);

        assert commandHistoryManager.undo() == true;

        assert commandHistoryManager.redo() == true;

        assert commandHistoryManager.undo() == true;

        assert commandHistoryManager.undo() == false;

        assert commandHistoryManager.undo() == false;

        commandHistoryManager.execute(d1);

        assert commandHistoryManager.redo() == true;

        assert commandHistoryManager.redo() == false;

        assert commandHistoryManager.redo() == false;

        assert commandHistoryManager.undo() == true;

        assert commandHistoryManager.redo() == true;

        // 반복
    }
    @Test
    void main() {
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

        //testDrawPixelCommand();
        //testDrawPixelCommand2();
        test3();

    }
}