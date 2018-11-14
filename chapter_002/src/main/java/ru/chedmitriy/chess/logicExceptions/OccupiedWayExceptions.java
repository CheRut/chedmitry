package ru.chedmitriy.chess.logicexceptions;

import java.util.logging.Logger;

/**
 * @author Dmitry Cherutsa on 17.12.2016.
 * @version $Id$
 * @project junior
 * @since 0.1
 */
public class OccupiedWayExceptions extends Exception {
    private Logger lg = Logger.getLogger(getClass().getName());
    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public OccupiedWayExceptions() {
    }

    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code Throwable} instance
     * (which may be {@code null}).
     */
    @Override
    public String getMessage() {
        lg.info("Невозможно выполнить перемещение фигуры."
                + "Не все ячейки свободны");
        return super.getMessage();
    }
}
