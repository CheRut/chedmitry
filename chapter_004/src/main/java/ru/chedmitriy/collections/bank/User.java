package ru.chedmitriy.collections.bank;

import ru.chedmitriy.collections.bank.exceptions.UserNotFoundException;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return passport != null ? passport.equals(user.passport) : user.passport == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}
