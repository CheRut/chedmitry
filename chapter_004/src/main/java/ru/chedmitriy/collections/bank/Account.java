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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(account.value, value) != 0) return false;
        return requisites != null ? requisites.equals(account.requisites) : account.requisites == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (requisites != null ? requisites.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "value=" + value +
                ", requisites='" + requisites + '\'' +
                '}';
    }
}
