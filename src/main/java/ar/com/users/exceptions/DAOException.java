package ar.com.users.exceptions;

public class DAOException extends Exception {

    private static final String MESSAGE = "Generic DAO Exception";

    public DAOException() {
        this(MESSAGE);
    }

    public DAOException(String message) {
        super(message);
    }

}
