package com.anararabli.abbtech.exception;

public abstract class BaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    /**
     * Optional arguments for the error.
     */
    public final Object[] args;

    /**
     * Instance of {@link BaseErrorService} that provides error details.
     */
    public final BaseErrorService baseErrorService;

    /**
     * Constructor for {@link BaseException} with throwable and additional arguments.
     *
     * @param baseErrorService The error service providing error details.
     * @param throwable        The root cause of the exception.
     * @param args             Additional arguments for the error.
     */
    protected BaseException(BaseErrorService baseErrorService, Throwable throwable, Object... args) {
        super(baseErrorService.getMessage(), throwable);
        this.baseErrorService = baseErrorService;
        this.args = args;
    }

    /**
     * Constructor for {@link BaseException} with additional arguments.
     *
     * @param baseErrorService The error service providing error details.
     * @param args             Additional arguments for the error.
     */
    protected BaseException(BaseErrorService baseErrorService, Object... args) {
        super(baseErrorService.getMessage());
        this.baseErrorService = baseErrorService;
        this.args = args;
    }

}
