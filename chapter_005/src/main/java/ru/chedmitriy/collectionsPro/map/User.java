package ru.chedmitriy.collectionsPro.map;

import java.util.Calendar;

public class User {

    /**
     * параметр name дял Объекта
     * User
     */
    String name;
    /**
     * количесвтенный
     * параметр children
     * для объекта User
     */
    int children;

    /**
     * параметр birthday
     * для объекта User
     */
    Calendar birthday;

    /**
     * конструтор клаасса
     * User:
     * @param name - именной параметр Объекта
     * @param children - количественное состояние
     *                 параметра children Объекта
     * @param birthday - хронологическое состояние
     *                 параметра birthday Объекта
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
