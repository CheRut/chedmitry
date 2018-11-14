package ru.chedmitriy.arraysort;

import java.util.*;

/**
 * класс реализует сортировку
 * объектов User
 *
 *
 * */
public class SortUser {

    /**
     * Метод сортирует
     * объекты в принятом списке
     * по возрасту
     * @param usList - список объектов User
     * @return TreeSet список объектов User отсортированных
     * по возрастанию
     * */
    public Set<User> sort(List<User> usList) {
        TreeSet<User> result = new TreeSet<>();
        result.addAll(usList);
        return result;
    }
    /**
     * .
     * Метод выполняющий сортировку
     * списка по хэшкоду элементов
     * в порядке возрастания
     * @param userList - список, гдесортируются значения
     * @return - отсортированный список
     * */
    public List<User> sortHash(List<User> userList) {
        userList.sort(new Comparator<User>() {
            public int compare(User o1, User o2) {
                int result = 0;
                if (o1.hashCode() > o2.hashCode()) {
                    result = 1;
                } else if (o1.hashCode() < o2.hashCode()) {
                    result = -1;
                }
                return result;
            }

        });
        return userList;
    }
    /**
     * .
     * Метод выполняющий сортировку
     * списка по длине строкового параметра
     * name объекта User
     * по возрастанию
     * @param userList - список, где сортируются значения
     * @return - отсортированный список
     * */
    public List<User> sortLength(List<User> userList) {
        userList.sort(new Comparator<User>() {
            public int compare(User o1, User o2) {
                int result;
                if (o1.getName().length() > o2.getName().length()) {
                    result = 1;
                } else if (o1.getName().length() < o2.getName().length()) {
                    result = -1;
                } else {
                    result = 0;
                }
                return result;
            }
        });
        return userList;
    }
}
