package academy.pocu.comp2500.assignment4;

public interface ICommand {
    void execute(Canvas canvas);
    boolean undo();
    boolean redo();
}