package ru.chedmitriy.collectionsPro.exceptions;

/**
 * Created by d1msan on 14.06.2017.
 */
public class DuplicateKeyException extends Exception {
    public DuplicateKeyException() {
    }

    @Override
    public String getMessage() {
        return "Элемент с таким ключом уже имеется в списке";
    }
}
