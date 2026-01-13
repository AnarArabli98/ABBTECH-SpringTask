package com.anararabli.abbtech.exception;

import lombok.Getter;

@Getter
public class CarException extends BaseException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for {@link CarException} with a throwable and additional arguments.
     *
     * @param baseErrorService The error service providing error details.
     * @param throwable        The root cause of the exception.
     * @param args             Additional arguments for the error.
     */
    public CarException(BaseErrorService baseErrorService, Throwable throwable, Object... args) {
        super(baseErrorService, throwable, args);
    }

    /**
     * Constructor for {@link CarException} with additional arguments.
     *
     * @param baseErrorService The error service providing error details.
     * @param args             Additional arguments for the error.
     */
    public CarException(BaseErrorService baseErrorService, Object... args) {
        super(baseErrorService, args);
    }

}
