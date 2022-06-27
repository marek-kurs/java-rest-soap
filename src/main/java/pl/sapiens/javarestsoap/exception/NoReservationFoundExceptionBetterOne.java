package pl.sapiens.javarestsoap.exception;

public class NoReservationFoundExceptionBetterOne extends RuntimeException {
    public NoReservationFoundExceptionBetterOne() {
    }

    public NoReservationFoundExceptionBetterOne(String message) {
        super(message);
    }

    public NoReservationFoundExceptionBetterOne(String message, Throwable cause) {
        super(message, cause);
    }

    public NoReservationFoundExceptionBetterOne(Throwable cause) {
        super(cause);
    }

    public NoReservationFoundExceptionBetterOne(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
