package pl.sapiens.javarestsoap.solid.exception;

public class NoFileExistException extends RuntimeException {
    public NoFileExistException() {
    }

    public NoFileExistException(String message) {
        super(message);
    }

    public NoFileExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoFileExistException(Throwable cause) {
        super(cause);
    }

    public NoFileExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
