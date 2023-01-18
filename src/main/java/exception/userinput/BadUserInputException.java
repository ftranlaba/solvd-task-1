package exception.userinput;

public class BadUserInputException extends Exception {
    public BadUserInputException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
