package backEnd;

import java.io.Serializable;
import java.rmi.server.ExportException;

public class InvalidAmoutOfInputsException extends Exception implements Serializable {
    public InvalidAmoutOfInputsException() {
        super("Invalid amount of inputs\n");
    }
}
