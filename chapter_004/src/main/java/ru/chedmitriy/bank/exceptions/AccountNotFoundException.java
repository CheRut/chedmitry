package ru.chedmitriy.bank.exceptions;
/**
 * Подкласс исключения
 * При обращении к счету
 * Account объекта User
 * Если счета не существует или
 * он не принадлежит определенному
 * User, выпадет исключение
 * */
public class AccountNotFoundException extends Exception {
    /**
     * Конструктор,
     * подкласса
     * исключения
     **/
    public AccountNotFoundException() {

    }

    /**
     * Переопределим выпадающее сообщение
     * при исключении
     *
     * */
    @Override
    public String getMessage() {
        return "Account incorrect";
    }
}
