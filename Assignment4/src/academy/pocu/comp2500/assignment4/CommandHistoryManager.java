package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.HashSet;

public class CommandHistoryManager {
    private Canvas canvas;
    private ICommand iCommand;
    private ArrayList<ICommand> iCommandArrayList = new ArrayList<>();
    private int iCommandArrayListCurrentcount = 0;

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
    }

    public boolean execute(ICommand iCommand) {
        this.iCommandArrayList.add(iCommand);
        iCommandArrayListCurrentcount++;
        return this.iCommand.execute(this.canvas);
    }

    public boolean canUndo() {
        if (this.iCommandArrayListCurrentcount == 0) {
            return false;
        }

        for (int i = 0; i < this.iCommandArrayList.size(); i++) {
            this.iCommandArrayList.get(i).undo();
        }

        return this.iCommand.undo();
    }

    public boolean canRedo() {
        return this.iCommand.redo();
    }

    public boolean undo() {
        return this.iCommand.undo();
    }

    public boolean redo() {
        return this.iCommand.redo();
    }
}