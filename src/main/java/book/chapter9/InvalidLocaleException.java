package book.chapter9;

public class InvalidLocaleException extends Exception {
    public InvalidLocaleException() {
    }

    public InvalidLocaleException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidLocaleException(String message) {
        super(message);
    }

    public InvalidLocaleException(Throwable cause) {
        super(cause);
    }
}
