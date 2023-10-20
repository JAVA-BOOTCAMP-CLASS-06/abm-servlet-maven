package ar.com.users.exceptions;

public class NotFoundBOException extends BOException {

    private static final String MESSAGE = "Not Found BO Exception";

    public NotFoundBOException() {
        super(MESSAGE);
    }
}
