package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.*;
import academy.pocu.comp2500.assignment4.registry.Registry;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    void testDrawPixelCommand2 () {
        Canvas canvas = new Canvas(3, 3);
        CommandHistoryManager chm = new CommandHistoryManager(canvas);
        ArrayList<ICommand> commandList = new ArrayList<>();
        commandList.add(new DrawPixelCommand(1, 2, '3'));
/*        commandList.add(new CommandDecreasePixel(1, 2));
        commandList.add(new CommandIncreasePixel(1, 2));
        commandList.add(new CommandFillHorizontalLine(3, 'h'));
        commandList.add(new CommandFillVerticalLine(3, 'h'));
        commandList.add(new CommandToUpper(3, 2));
        commandList.add(new CommandToLower(3, 2));
        commandList.add(new CommandClear());*/
        for (ICommand command : commandList) {
            assert (chm.execute(command) == true);
            assert (chm.undo() == true);
            assert (chm.redo() == true);
            canvas.drawPixel(0, 0, '5');
            assert (chm.undo() == false);
            canvas.drawPixel(0, 0, ' ');
            assert (chm.undo() == true);
            canvas.drawPixel(0, 0, '5');
            assert (chm.redo() == false);
            canvas.drawPixel(0, 0, ' ');
            assert (chm.redo() == true);
        }

    }
    void testDrawPixelCommand() {
        Canvas canvas = new Canvas(2, 2);

        System.out.println(canvas.getDrawing());

        CommandHistoryManager commandHistoryManager = new CommandHistoryManager(canvas);

        // 반복
        DrawPixelCommand d1 = new DrawPixelCommand(0, 0, '?');

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

        testDrawPixelCommand();
        testDrawPixelCommand2();
    }
}