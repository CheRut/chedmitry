package ru.chedmitriy.collections.organization;


import java.util.*;
/**
 * Класс,позволяющий работать со структурами
 * организаций
 * */
public class Structure {
    /**
     * Определим собственный
     * класс - компоратор
     * */
    OrganizationStructureComparator oSC = new OrganizationStructureComparator();
    /**
     * Множество всех организаций
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
     * Возвращаем множество организаций
     * @return множество structureList
     * */
    public TreeSet<Organization> getStructureList() {
        return structureList;
    }
}
