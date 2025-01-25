package backEnd;

import java.io.Serializable;

public class NoLoginException extends Exception implements Serializable {
    public NoLoginException() {
        super("Can not record without login!");
    }
}

