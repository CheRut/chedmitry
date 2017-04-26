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
/**
 * Конструктор,
 * подкласса
 * исключения
 * * */
    public AccountNotFoundException(String message) {
        super(message);
    }

}
