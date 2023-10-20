package ar.com.users.exceptions;

public class DNIDuplicateBOException extends BOException {

    private static final String MESSAGE = "This DNI is duplicated";

    public DNIDuplicateBOException() {
        super(MESSAGE);
    }
}
