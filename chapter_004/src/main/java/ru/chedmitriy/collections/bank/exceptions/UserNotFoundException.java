package ru.chedmitriy.collections.bank.exceptions;

/**
 * Подкласс исключений:
 * Если User передаваемый в параметрах
 * метода или возвращаемый при вызове
 * не существует в базе данных
 * выпадает исключение данного подкласса
 * */
public class UserNotFoundException extends Exception {
    /**
     * Конструктор
     * подкласса,указывается в
     * точке возможного выпадания
     * исключения
     * */
    public UserNotFoundException() { }
    @Override
    public String getMessage() {
        return "User parameter incorrect";
    }
}
