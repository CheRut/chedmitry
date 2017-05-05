package ru.chedmitriy.collections.organization;
/**
 * Отделы каждой организации будут
 * создаваться в этом классе
 *
 * */
public class Department {
    /**
     * ПАраметр - название отдела
     * */
    private  final String name;

/**
 * При определении нового отдела
 *
 *
 * */
    public Department(String name) {

        this.name = name;



    }

    public String getName() {
        return name;
    }


}
