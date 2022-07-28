package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.App;
import academy.pocu.comp2500.assignment4.Canvas;
import academy.pocu.comp2500.assignment4.CommandHistoryManager;
import academy.pocu.comp2500.assignment4.DrawPixelCommand;
import academy.pocu.comp2500.assignment4.registry.Registry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    void testDrawPixelCommand() {
        Canvas canvas = new Canvas(5, 5);

        System.out.println(canvas.getDrawing());

        CommandHistoryManager commandHistoryManager = new CommandHistoryManager(canvas);

        // 반복
        DrawPixelCommand d1 = new DrawPixelCommand(3, 3, '?');

        commandHistoryManager.execute(d1);

        assert commandHistoryManager.undo() == true;

        assert commandHistoryManager.redo() == true;

        assert commandHistoryManager.undo() == true;

        assert commandHistoryManager.undo() == false;

        assert commandHistoryManager.redo() == true;

        assert commandHistoryManager.redo() == false;

        // 반복
    }
    @Test
    void main() {
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

        testDrawPixelCommand();
    }
}