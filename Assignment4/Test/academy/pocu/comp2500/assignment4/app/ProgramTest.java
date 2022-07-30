package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.*;
import academy.pocu.comp2500.assignment4.registry.Registry;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    void mixTest4619() {
        Canvas canvas = new Canvas(30, 30);
        CommandHistoryManager h = new CommandHistoryManager(canvas);

        h.undo();
        h.execute(new ClearCommand());
        h.execute(new ClearCommand());
        h.execute(new ToLowerCommand(0, 25));
        h.execute(new DecreasePixelCommand(12, 3));
        h.execute(new ClearCommand());
        h.execute(new FillHorizontalLineCommand(5, '='));
            //System.out.println(canvas.getDrawing());
        h.execute(new IncreasePixelCommand(18, 18));
            //System.out.println(canvas.getDrawing());
        h.execute(new FillHorizontalLineCommand(10, 'v'));
            //System.out.println(canvas.getDrawing());
        h.undo();
            //System.out.println(canvas.getDrawing());
        h.execute(new FillHorizontalLineCommand(27, '$'));
            //System.out.println(canvas.getDrawing());
        h.undo();
            //System.out.println(canvas.getDrawing());
        h.undo();

            System.out.println(canvas.getDrawing());
    }
    void mixTest4610() {
        Canvas canvas = new Canvas(30, 30);
        CommandHistoryManager h = new CommandHistoryManager(canvas);

        h.execute(new FillHorizontalLineCommand(4, '\\'));
        h.execute(new FillVerticalLineCommand(3, '4'));
        h.execute(new ClearCommand());
        h.execute(new ToLowerCommand(15, 3));
        h.execute(new FillHorizontalLineCommand(14, ' '));
        h.redo();
        h.execute(new ToLowerCommand(20, 3));
        h.execute(new ClearCommand());
        h.execute(new FillHorizontalLineCommand(19, 'm'));
        h.execute(new DecreasePixelCommand(18, 2));
        h.execute(new ToUpperCommand(13, 6));
        h.execute(new FillVerticalLineCommand(26, 'I'));
        h.execute(new IncreasePixelCommand(2, 7));
        h.execute(new ClearCommand());
        h.execute(new IncreasePixelCommand(7, 18));
        h.execute(new ToLowerCommand(27, 24));
        h.execute(new FillVerticalLineCommand(1, '7'));
        h.execute(new IncreasePixelCommand(18, 18));
        h.execute(new DecreasePixelCommand(10, 12));
        h.undo();

        System.out.println(canvas.getDrawing());

        canvas = new Canvas(30, 30);
        h = new CommandHistoryManager(canvas);

        h.redo();
        h.redo();
        h.execute(new ToUpperCommand(21, 8));
        h.execute(new DrawPixelCommand(14, 10, 'v'));
        h.redo();
        h.undo();
        h.redo();
        h.execute(new DecreasePixelCommand(23, 17));
        h.undo();

        System.out.println(canvas.getDrawing());
    }

    void mixTest5(){
        Canvas canvas = new Canvas(30, 30);
        CommandHistoryManager historyManager = new CommandHistoryManager(canvas);

        historyManager.execute(new FillHorizontalLineCommand(10, 't'));
        historyManager.execute(new FillHorizontalLineCommand(2, 'k'));
        historyManager.execute(new DrawPixelCommand(8, 6, '0'));
        historyManager.execute(new ClearCommand());
        historyManager.undo();
        historyManager.undo();
        historyManager.execute(new ClearCommand());
        historyManager.execute(new DrawPixelCommand(22, 18, 'k'));
        historyManager.execute(new ClearCommand());
        historyManager.undo();
        historyManager.execute(new FillHorizontalLineCommand(12, '8'));
        historyManager.execute(new DecreasePixelCommand(27, 7));
        historyManager.undo();
        historyManager.execute(new DecreasePixelCommand(26, 12));
        historyManager.execute(new ToUpperCommand(14, 14));
        historyManager.execute(new ToUpperCommand(3, 18));
        historyManager.redo();

        System.out.println(canvas.getDrawing());
    }

    void mixTest4() {
        Canvas canvas = new Canvas(25, 30);
        CommandHistoryManager historyManager = new CommandHistoryManager(canvas);
        historyManager.redo();
        historyManager.execute(new FillHorizontalLineCommand(8, 'y'));
        historyManager.execute(new DrawPixelCommand(2, 11, '.'));
        historyManager.execute(new ToLowerCommand(23, 28));
        historyManager.execute(new DrawPixelCommand(16, 29, '?'));
        historyManager.execute(new IncreasePixelCommand(9, 27));
        historyManager.execute(new FillHorizontalLineCommand(3, '8'));
        historyManager.execute(new DrawPixelCommand(10, 9, 'N'));
        historyManager.execute(new DrawPixelCommand(17, 17, 'c'));
        //System.out.println(canvas.getDrawing());
        assert historyManager.redo() == false;
        //System.out.println(canvas.getDrawing());
        historyManager.execute(new DecreasePixelCommand(21, 21));
        //System.out.println(canvas.getDrawing());
        historyManager.execute(new ToUpperCommand(18, 7));
        //System.out.println(canvas.getDrawing());
        historyManager.undo();
        //System.out.println(canvas.getDrawing());
        historyManager.undo();
        System.out.println(canvas.getDrawing());
    }

    void mixTest3() {
        Canvas canvas = new Canvas(30, 25);
        CommandHistoryManager historyManager = new CommandHistoryManager(canvas);
        historyManager.execute(new IncreasePixelCommand(21, 13));
        historyManager.execute(new ToUpperCommand(22, 14));
        historyManager.execute(new DecreasePixelCommand(12, 8));
        //System.out.println(canvas.getDrawing());
        historyManager.execute(new FillHorizontalLineCommand(8, '2'));
        //System.out.println(canvas.getDrawing());
        historyManager.execute(new ToUpperCommand(25, 18));
        //System.out.println(canvas.getDrawing());
        historyManager.undo();
        //System.out.println(canvas.getDrawing());
        historyManager.undo();
        System.out.println(canvas.getDrawing());
    }

    void mixTest2() {
        Canvas canvas = new Canvas(30, 25);
        CommandHistoryManager historyManager = new CommandHistoryManager(canvas);
        historyManager.execute(new FillHorizontalLineCommand(10, 't'));
        historyManager.execute(new FillHorizontalLineCommand(2, 'k'));
        historyManager.execute(new DrawPixelCommand(8, 6, '0'));
        historyManager.execute(new ClearCommand());
        historyManager.undo();
        historyManager.undo();
        historyManager.execute(new ClearCommand());
        historyManager.execute(new DrawPixelCommand(22, 18, 'k'));
        //System.out.println(canvas.getDrawing());
        historyManager.execute(new ClearCommand());
        //System.out.println(canvas.getDrawing());
        assert historyManager.undo() == true;
        System.out.println(canvas.getDrawing());

    }

    void mixTest() {
        Canvas canvas = new Canvas(30, 25);

        CommandHistoryManager historyManager = new CommandHistoryManager(canvas);

        historyManager.execute(new FillVerticalLineCommand(21, '8'));
        //System.out.println(canvas.getDrawing());
        historyManager.execute(new FillHorizontalLineCommand(10, '#'));
        //System.out.println(canvas.getDrawing());

        //assert historyManager.execute(new DrawPixelCommand(0, 0, '?')) == true;
        assert historyManager.execute(new ToUpperCommand(5, 1)) == true;

        //System.out.println(canvas.getDrawing());
        assert historyManager.redo() == false;
        //System.out.println(canvas.getDrawing());
        assert historyManager.undo() == true;
        System.out.println(canvas.getDrawing());

    }

    void overdrawTestL14() {
        OverdrawAnalyzer analyzer = new OverdrawAnalyzer(6, 6);
        CommandHistoryManager manager = new CommandHistoryManager((Canvas) analyzer);

        ArrayList<ICommand> commands = new ArrayList<>();
        commands.add(new ClearCommand());
        commands.add(new FillVerticalLineCommand(1, '.'));
        commands.add(new IncreasePixelCommand(0, 3));
        commands.add(new ToUpperCommand(1, 0));
        commands.add(new FillHorizontalLineCommand(4, 'X'));
        commands.add(new FillHorizontalLineCommand(4, 'V'));
        commands.add(new FillVerticalLineCommand(4, 't'));
        commands.add(new IncreasePixelCommand(4, 2));
        commands.add(new ToLowerCommand(2, 3));
        commands.add(new IncreasePixelCommand(0, 0));
        commands.add(new FillVerticalLineCommand(2, 'm'));
        commands.add(new ToLowerCommand(0, 4));
        commands.add(new ToLowerCommand(1, 0));
        commands.add(new DrawPixelCommand(3, 1, 'o'));
        commands.add(new FillVerticalLineCommand(2, 'y'));
        commands.add(new FillHorizontalLineCommand(1, 'A'));


        for (int i = 0; i < 8; i++) {
            manager.execute(commands.get(i));
        }

        manager.redo();

        for (int i = 8; i < 10; i++) {
            manager.execute(commands.get(i));
        }

        manager.redo();

        manager.execute(commands.get(10));

        manager.undo();

        for (int i = 11; i < 14; i++) {
            manager.execute(commands.get(i));
        }

        manager.undo();

        for (int i = 14; i < 16; i++) {
            manager.execute(commands.get(i));
        }


        System.out.print(analyzer.getDrawing());
        System.out.println(analyzer.getPixelHistory(0, 0)); // 오류 생기는 부분 직접 입력

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.printf("%d %d: ", i, j);
                System.out.print(analyzer.getPixelHistory(i, j)); // 오류 생기는 부분 직접 입력
                System.out.println();
            }
        }

    }

    void clearCommandTest() {
        Canvas canvas = new Canvas(30, 25);
        CommandHistoryManager historyManager = new CommandHistoryManager(canvas);
        assert historyManager.undo() == false;
        assert historyManager.undo() == false;
        historyManager.execute(new ToLowerCommand(0,0));
        historyManager.execute(new DecreasePixelCommand(1, 1));
        historyManager.execute(new ClearCommand());
        historyManager.execute(new DrawPixelCommand(2, 2, '!'));
        historyManager.undo();
        historyManager.execute(new FillVerticalLineCommand(25, 'p'));
        historyManager.execute(new ToLowerCommand(1, 0));
        historyManager.redo();
        historyManager.execute(new IncreasePixelCommand(15, 22));
        historyManager.execute(new IncreasePixelCommand(16, 3));
        historyManager.execute(new ToLowerCommand(4, 2));
        System.out.println(canvas.getDrawing());
        historyManager.execute(new ClearCommand());
        //historyManager.execute(new DrawPixelCommand(0, 0, '0'));
        System.out.println(canvas.getDrawing());
        assert historyManager.redo() == false;
        System.out.println(canvas.getDrawing());
        assert historyManager.undo() == true;
        System.out.println(canvas.getDrawing());



    }

    void test3() {
        Canvas canvas = new Canvas(2, 2);
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

    void testDrawPixelCommand2() {
        Canvas canvas = new Canvas(4, 4);
        CommandHistoryManager chm = new CommandHistoryManager(canvas);
        ArrayList<ICommand> commandList = new ArrayList<>();
        commandList.add(new DrawPixelCommand(1, 2, '3'));

        commandList.add(new DecreasePixelCommand(1, 2));
        commandList.add(new IncreasePixelCommand(1, 2));
        commandList.add(new FillHorizontalLineCommand(3, 'h'));
        commandList.add(new FillVerticalLineCommand(3, 'h'));
        commandList.add(new ToUpperCommand(3, 2));
        commandList.add(new ToLowerCommand(3, 2));
        commandList.add(new ClearCommand());
        for (ICommand command : commandList) {
            assert (chm.execute(command) == true);
            char a = canvas.getPixel(1, 2);
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

        //canvas.drawPixel(1,1,'1');


        CommandHistoryManager commandHistoryManager = new CommandHistoryManager(canvas);

        // 반복
        DrawPixelCommand d1 = new DrawPixelCommand(0, 0, '0');
        DrawPixelCommand d2 = new DrawPixelCommand(0, 0, '0');

        commandHistoryManager.execute(d1);
        commandHistoryManager.execute(d2);

        assert commandHistoryManager.redo() == false;

        assert commandHistoryManager.undo() == true;

        // 반복
    }

    @Test
    void main() {
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();

        //testDrawPixelCommand();
        //testDrawPixelCommand2();
        //test3();

        //overdrawTestL14();

        //clearCommandTest();

/*        mixTest();
        mixTest5();
        mixTest4();
        mixTest3();

        mixTest4619();
        mixTest4610();*/


        LinkedList<Character> arr[][] = new LinkedList[2][2];
        arr[0][0] = new LinkedList<>();
        //arr[0][0].add('a');

        System.out.println(arr[0][0]);

        LinkedList<Character> l = new LinkedList<>();
        l.add('a');

        ArrayList<LinkedList<Character>> array = new ArrayList<>();
        array.add(l);
        System.out.println(array.get(0));
    }
}