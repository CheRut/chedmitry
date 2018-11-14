package ru.chedmitriy.exceptions;

/**
 * Created by dimsan on 12.05.2017.
 */
public class CatchNullPointExceptions extends Exception {
    
    public CatchNullPointExceptions() {
    }

    @Override
    public String getMessage() {
        return "Элемент не найден";
    }
}
