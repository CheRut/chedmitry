package ru.chedmitriy.collections.organization;
/**
 * Класс получает свойства
 * интерфейса Comparator
 * */
import java.util.Comparator;

class OrganizationStructureComparator implements Comparator<Organization> {
    /**
     * Переопределенный метод,задающий
     * алгоритм сортировки дерева множеств
     * @param o1
     * @param o2  - передаваемые параметры
     *            объекта Organization
     * @return сортировка по имени объектов
     * */

    @Override
    public int compare(Organization o1, Organization o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
