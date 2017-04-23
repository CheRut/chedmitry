package ru.chedmitriy.collections.bank;

/**
 * .
 * Класс определяет параметры
 * банковского счета: количество денег
 * и номер счета.
 * */
public class Account {
    /**
     * .
     * количество денег
     * на счете
     * */
    private double value;
    /**
     * .
     * Номер счета(реквизиты)
     * */
    private String requisites;
    /**
     * .
     * Конструктор по умолчанию
     * */
    public  Account() {}
    /**
     * .
     * Конструктор с параметрами
     * @param value  -  количество денег
     * @param requisites - номер счета
     **/
    public Account(final double value, final String requisites) {
        this.value = value;
        this.requisites = requisites;
    }
    /**
     * .
     * Метод для получения значения
     * переменной value
     *
     * */
    public double getValue() {
        return value;
    }
    /**
     *.
     * Метод для занесения/изменения
     * значения параметра
     *
     * */
    public void setValue(double value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }
}
