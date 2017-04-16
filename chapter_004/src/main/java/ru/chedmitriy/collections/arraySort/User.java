package ru.chedmitriy.collections.arraySort;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Программа демонстриует реализацию интерфейса Comparable
 * Сортировка обектов некоторого списка по критерию,здесь
 * целочисленная переменная - age
 *
 */
public class User implements Comparable <User>{
    /**
     * имя объекта User
     * */
    private String name;
    /**
     * возраст объекта User
     * */
    private int age;
    /**
     * параметр хэшкода в списке
     * */

    private int hashParametr = 0;

    /**
     * Конструктор
     * с параметрами  и Возраст
     * @param name - Имя
     * @param age - Возраст
     * */


    User(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }
    /**
     * Конструктор
     * по  умолчанию
     * */
    public User() {
    }

    /**
     * переопределенный метод интерфейса Comparable
     * @param user - объект класса User
     * @return - int: Если  метод возвращает отрицательное число,
     * текущий объект будет располагаться перед тем, который передается через параметр.
     * Если метод вернет положительное число, то, наоборот, после второго объекта.
     * Если метод возвратит ноль, значит, оба объекта равны.
     * */
    @Override
    public int compareTo(User user) {
        System.out.println(this.age - user.getAge()+"*");
        return this.age - user.getAge();

    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }


}
