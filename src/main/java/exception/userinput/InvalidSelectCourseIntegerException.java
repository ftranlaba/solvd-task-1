package exception.userinput;

public class InvalidSelectCourseIntegerException extends BadUserInputException {
    public InvalidSelectCourseIntegerException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
