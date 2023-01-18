package exception;

public class InvalidMenuOptionException extends RuntimeException {
    public InvalidMenuOptionException(String errorMessage) {
        super(errorMessage);
    }
}
