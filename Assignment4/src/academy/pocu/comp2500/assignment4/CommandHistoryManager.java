package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class CommandHistoryManager {
    private Canvas canvas;
    private ICommand iCommand;
    private ArrayList<ICommand> iCommandArrayList = new ArrayList<>();
    private int index = 0;
    private boolean isExecuted = false;

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
    }

    public boolean execute(ICommand iCommand) {
        this.isExecuted = true;
        this.iCommand = iCommand;
        if (this.iCommand.execute(this.canvas)) {
            this.iCommandArrayList.add(iCommand);
            index++;
            return true;
        }

        return false;
    }

    public boolean canUndo() {
        if (isExecuted && this.index != 0) {
            boolean result = iCommandArrayList.get(this.index - 1).undo();
            if (result) {
                iCommandArrayList.get(this.index - 1).redo();
                return result;
            }

            if (!result && this.index > 1) {
                this.index--;
                boolean result2 = iCommandArrayList.get(this.index - 1).undo();
                if (result2) {
                    iCommandArrayList.get(this.index - 1).redo();
                    return result2;
                }
            }
            return result;
        }
        return false;
    }

    public boolean canRedo() {
        if (isExecuted && this.index <= this.iCommandArrayList.size()) {
            boolean result = iCommandArrayList.get(this.index - 1).redo();
            if (result) {
                iCommandArrayList.get(this.index - 1).undo();
                return result;
            }

            if (!result && this.index < this.iCommandArrayList.size()) {
                this.index++;
                boolean result2 = iCommandArrayList.get(this.index - 1).redo();
                if (result2) {
                    iCommandArrayList.get(this.index - 1).undo();
                    return result2;
                }
            }
            return result;
        }
        return false;
    }

    public boolean undo() {
        if (isExecuted && this.index != 0) {
            boolean result = iCommandArrayList.get(this.index - 1).undo();
            if (!result && this.index > 1) {
                this.index--;
                return iCommandArrayList.get(this.index - 1).undo();
            }
            return result;
        }
        return false;
    }

    public boolean redo() {
        if (isExecuted && this.index <= this.iCommandArrayList.size()) {
            boolean result = iCommandArrayList.get(this.index - 1).redo();
            if (!result && this.index < this.iCommandArrayList.size()) {
                this.index++;
                return iCommandArrayList.get(this.index - 1).redo();
            }

            return result;
        }
        return false;
    }
}