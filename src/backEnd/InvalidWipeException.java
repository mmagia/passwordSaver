package backEnd;

public class InvalidWipeException extends Exception {
    public InvalidWipeException() {
        super("Insert only y/n!");
    }
}
