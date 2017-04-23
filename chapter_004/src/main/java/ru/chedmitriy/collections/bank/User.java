package ru.chedmitriy.collections.bank;
/**
 * .
 * Класс клиента.Структура
 * каждого клиента выстраивается согласно
 * данному классу
 * */
public class User {
    /**
     * Переменная name - имя клиента
     * */
    private String name;
    /**
     * Переменная passport
     * */
    private String passport;

/**
 * .
 * Конструктор клиента
 * @param name  - имя клиента
 * @param passport - паспортные данные
 * */
    public User(final String name, final String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
