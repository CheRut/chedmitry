package ru.chedmitriy.collections.mapExample;

/**
*
*/
public class User {
    private String name;
    private int id;
    private String city;
    public User(int id,String name,String city) {
        this.setId(id);
        this.setName(name);
        this.setCity(city);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
