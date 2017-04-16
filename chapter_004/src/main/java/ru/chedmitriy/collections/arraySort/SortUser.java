package ru.chedmitriy.collections.arraySort;

import java.util.*;

/**
 * класс реализует сортировку
 * объектов User
 *
 *
 * */
public class SortUser extends User {
    public SortUser(){}
     /**
      * конструктор с параметрами
      * @param name - имя объекта
      * @param age - возраст объекта
      * */
     public SortUser(String name, int age) {
        super(name, age);
    }
/**
 * Метод сортирует
 * объекты в принятом списке
 * по возрасту
 * @param usList - список объектов User
 * @return TreeSet список объектов User отсортированных
 * по возрастанию
 * */
    public Set<User> sort (List<User> usList) {
        for (int i = 0; i <usList.size() ; i++) {
            for (int j = 0; j <usList.size(); j++) {
                compareTo(usList.get(i));
            }
        }
        TreeSet<User> result = new TreeSet<>();
        result.addAll(usList);
        return result;
    }


}
