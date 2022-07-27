package academy.pocu.comp2500.assignment4;

import java.util.HashSet;

public class CommandHistoryManager {
    private Canvas canvas;
    private HashSet<ICommand> iCommandHashSet;

    private ICommand iCommand;

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
    }

    public boolean execute(ICommand iCommand) {
        if (this.iCommandHashSet.contains(iCommand)) {
            return false;
        }
        this.iCommand = iCommand;
        this.iCommandHashSet.add(iCommand);
        iCommand.execute(this.canvas);
        return true;
    }

    public boolean canUndo() {

        return true;
    }

    public boolean canRedo() {
        return true;
    }

    public boolean undo() {
        this.iCommand.undo();
        return false;
    }

    public boolean redo() {
        this.iCommand.redo();
        return false;
    }
}
