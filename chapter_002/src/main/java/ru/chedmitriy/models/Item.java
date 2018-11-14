package ru.chedmitriy.models;

import java.sql.Timestamp;

/**
 * Created by dimsan on 18.09.2016.
 */
public class Item {
    public String name;
    public String description;
    public Timestamp create;
    private String id;

    public Item() {

    }
    public Item(String name, String description) {
        this.name = name;
        this.description = description;

    }
    public Item(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;

    }
    public Item(String name, String description, Timestamp create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Timestamp getCreate() {
        return this.create;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;

    }
}
