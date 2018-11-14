package ru.chedmitriy.chess.logicexceptions;

import java.util.logging.Logger;

/**
 * @author Dmitry Cherutsa on 17.12.2016.
 * @version $Id$
 * @project junior
 * @since 0.1
 */
public class MovementException extends Exception {
    private Logger lg = Logger.getLogger(getClass().getName());



    public MovementException(String message) {
        super(message);

    }

    @Override
    public String getMessage() {

        return super.getMessage();
    }
}
