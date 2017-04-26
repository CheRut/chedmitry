package ru.chedmitriy.collections.bank.exceptions;
/**
 * Подкласс исключения
 * При обращении к счету
 * Account объекта User
 * Если счета не существует или
 * он не принадлежит определенному
 * User, выпадет исключение
 * */
public class AccountNotFoundException extends Exception {

    public AccountNotFoundException() { }
    /**
     * Конструктор,
     * подкласса
     * исключения
     **/

    @Override
    public String getMessage() {
        return "Account incorrect";
    }
}
