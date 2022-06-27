package pl.sapiens.javarestsoap.exception;

public class NoReservationFoundException extends Exception {
    public NoReservationFoundException() {
    }

    public NoReservationFoundException(String message) {
        super(message);
    }

    public NoReservationFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoReservationFoundException(Throwable cause) {
        super(cause);
    }

    public NoReservationFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
