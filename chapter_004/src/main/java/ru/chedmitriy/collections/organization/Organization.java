package ru.chedmitriy.collections.organization;

import java.util.Comparator;

/**
 * Главный класс - несет в
 * себе информацию об организации,
 * вклюяает вс себя отделы и
 * отделения
 * */
public class Organization {
    /**
     *
     * Параметр name -
     * название организации
     * */
    private final String name;
    /**
     * Параметр dep -
     * отдел организации
     * */
    private final Department dep;
    /**
     * Параметр sd -
     * подразделение
     * */
    private final  Subdivision sd;

    /**
     * Конструктор принимает название организации и входящие
     * в ее состав отделы и подразделения
     * @param name - название организации
     * @param dep - отдел организации
     * @param sd - подразделение
     * */
    public Organization(String name,Department dep,Subdivision sd) {
        this.name = name;
        this.dep = dep;
        this.sd = sd;
    }
    /**
     *
     * Возвращаем полное название Организации с входящими
     * в ее состав отделами и подразделениями
     * @return - название организации,отдела и подразделения
     * */
    public String getName() {
        return  name+dep.getName()+sd.getName();
    }




}
