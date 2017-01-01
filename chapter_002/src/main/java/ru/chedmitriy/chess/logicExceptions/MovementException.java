package ru.chedmitriy.chess.logicExceptions;

import java.util.logging.Logger;

/**
 * @author Dmitry Cherutsa on 17.12.2016.
 * @version $Id$
 * @project junior
 * @since 0.1
 */
public class MovementException extends Exception{
    private Logger lg = Logger.getLogger(getClass().getName());

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public MovementException() {    }

    public MovementException(String message) {
        super(message);

    }

    @Override
    public String getMessage() {

        return super.getMessage();
    }
}
