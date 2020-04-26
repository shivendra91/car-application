package com.fincity.carapplication.exception;

public class CarException extends RuntimeException {
    private static final long serialVersionUID = 4630949848251482363L;

    public CarException(String message) {
        super(message);
    }

    public CarException(String message, Throwable exp) {
        super(message, exp);
    }
}
