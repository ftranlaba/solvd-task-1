package exception;

public class UniversityIsEmptyException extends RuntimeException {
    public UniversityIsEmptyException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
