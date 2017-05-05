package ru.chedmitriy.collections.organization;


import java.util.*;
/**
 * Класс,позволяющий работать со структурами
 * организаций
 * */
public class Structure {
    /**
     * Список всех организаций
     * с отделами и подразделениями
     *
     * */
    private final List<Organization> structureList = new ArrayList<>();
    /**
     * Для получения информации о
     * всех организациях при прямом порядке:
     * организация - отдел - подразделение
     * Используется интерфейс Comparator c
     * с переопределенным методом.
     *
     * */
    public  List<Organization> normalSorting(){
        (this.structureList).sort(new Comparator<Organization>() {
            @Override
            public int compare(Organization o1, Organization o2) {
                return
                        o1.getName().compareTo(o2.getName());
            }
        });

        showOrganizationStructure(this.structureList);

        return this.structureList;
    }
    /**
     * Отображение списка
     * всех организаций в
     * установленном порядке
     *
     * */
    private void showOrganizationStructure(Collection collection) {
        for (Organization aCollection : (Iterable<Organization>) collection) {
            System.out.println(aCollection.getName());

        }
    }
    /**
     * Возвращаем список организаций
     * @return список structureList
     * */
    public List<Organization> getStructureList() {
        return structureList;
    }
}
