package academy.pocu.comp2500.lab11;

public class OverflowException extends RuntimeException {
    private static final long serialVersionUID = 20L;

    public OverflowException(String message) {
        super(message);
    }
}
