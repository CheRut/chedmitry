package ru.chedmitriy.collections.mapExample;

/**
*
*/
public class User {
    private final String name;
    private final int id;
    private final String city;

    public User(int id,String name,String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
