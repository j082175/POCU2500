package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class CommandHistoryManager {
    private Canvas canvas;
    private ArrayList<ICommand> iCommandArrayList = new ArrayList<>();
    private int index = 0;
    private boolean isExecuted = false;

    public CommandHistoryManager(Canvas canvas) {
        this.canvas = canvas;
    }

    public boolean execute(ICommand iCommand) {
        this.isExecuted = true;

        if (iCommand.execute(this.canvas)) {
            if (this.index == this.iCommandArrayList.size()) {
                this.index++;
            }
            this.iCommandArrayList.add(iCommand);

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
            int current = this.index;
            if (!result && this.index > 1) {
                this.index--;
                while (this.index > 0) {
                    if (iCommandArrayList.get(this.index - 1).undo()) {
                        return true;
                    } else {
                        this.index--;
                        //return false;
                    }
                }


            }
            if (this.index == 0) {
                this.index = current;
                return false;
            }

            return result;
        }
        return false;

/*        if (isExecuted && this.index != 0) {
            boolean result = iCommandArrayList.get(this.index - 1).undo();
            if (!result && this.index > 1) {
                this.index--;
                return iCommandArrayList.get(this.index - 1).undo();
            }
            return result;
        }
        return false;*/
    }

    public boolean redo() {
        if (isExecuted && this.index <= this.iCommandArrayList.size()) {
            boolean result = iCommandArrayList.get(this.index - 1).redo();
            int current = this.index;
            if (!result && this.index < this.iCommandArrayList.size()) {
                this.index++;

                while (this.index <= this.iCommandArrayList.size()) {
                    if (iCommandArrayList.get(this.index - 1).redo()) {
                        return true;
                    } else {
                        this.index++;
                        //return false;
                    }
                }

            }

            if (this.index > this.iCommandArrayList.size()) {
                this.index = current;
                return false;
            }

            return result;
        }
        return false;

/*        if (isExecuted && this.index <= this.iCommandArrayList.size()) {
            boolean result = iCommandArrayList.get(this.index - 1).redo();
            if (!result && this.index < this.iCommandArrayList.size()) {
                this.index++;
                return iCommandArrayList.get(this.index - 1).redo();
            }
            return result;
        }
        return false;*/
    }
}