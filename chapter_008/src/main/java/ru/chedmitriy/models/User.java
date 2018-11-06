package ru.chedmitriy.models;

import java.util.Objects;

public class User {

    private  int id;
    private  String name;
    private  String email;
    private  String create;

    public User(int id, String name, String email, String create) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.create = create;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(create, user.create);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, create);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCreate() {
        return create;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", create='" + create + '\'' +
                '}';
    }
}
