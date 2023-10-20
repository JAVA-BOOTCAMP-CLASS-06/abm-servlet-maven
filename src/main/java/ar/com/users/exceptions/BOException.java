package ar.com.users.exceptions;

public class BOException extends Exception {

    private static final String MESSAGE = "Generic BO Exception";

    public BOException() {
        this(MESSAGE);
    }

    public BOException(String message) {
        super(message);
    }

}
