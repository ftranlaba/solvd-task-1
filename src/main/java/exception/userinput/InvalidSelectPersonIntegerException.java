package exception.userinput;

public class InvalidSelectPersonIntegerException extends BadUserInputException{
        public InvalidSelectPersonIntegerException(String errorMessage, Throwable err) {
            super(errorMessage, err);
        }

}
