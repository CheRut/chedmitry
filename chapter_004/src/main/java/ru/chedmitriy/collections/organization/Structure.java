package ru.chedmitriy.collections.organization;


import java.util.*;
/**
 * Класс,позволяющий работать со структурами
 * организаций
 * */
public class Structure {
    OrganizationStructureComparator oSC = new OrganizationStructureComparator();
    /**
     * Список всех организаций
     * с отделами и подразделениями
     *
     * */
    private final TreeSet<Organization> structureList = new TreeSet<>(oSC);

    /**
     * Отображение списка
     * всех организаций в
     * установленном порядке
     *
     * */
    public void showOrganizationStructure(Collection collection) {
        for (Organization aCollection : (Iterable<Organization>) collection) {
            System.out.println(aCollection.getName());

        }
    }
    /**
     * Возвращаем список организаций
     * @return список structureList
     * */
    public TreeSet<Organization> getStructureList() {
        return structureList;
    }
}
