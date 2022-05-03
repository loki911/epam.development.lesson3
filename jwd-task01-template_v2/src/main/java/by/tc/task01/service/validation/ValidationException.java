package by.tc.task01.service.validation;

public class ValidationException extends RuntimeException {

    public ValidationException(String errorMessage) {
        super(errorMessage);
    }

    public ValidationException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }
}
