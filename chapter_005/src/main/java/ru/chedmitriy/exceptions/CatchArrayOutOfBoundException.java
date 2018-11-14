package ru.chedmitriy.exceptions;

/**
 * Created by dimsan on 12.05.2017.
 */
public class CatchArrayOutOfBoundException extends Exception {

    public CatchArrayOutOfBoundException() {
    }

    @Override
    public String getMessage() {
        return "Значение индекса вне диапазона";
    }
}
