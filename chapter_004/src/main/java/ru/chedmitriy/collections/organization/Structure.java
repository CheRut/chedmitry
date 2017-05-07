package ru.chedmitriy.collections.organization;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * Клас обработки
 * данных организаций
 *
 * */
public class Structure {
    /**
     * Список организаций
     * */
    private final ArrayList<Organization> structureList = new ArrayList<>();
    /**
     *
     * Конструктор по умолчанию
     *
     * */
    public Structure() {
    }
    /**
     * метод сортировки
     * списка организаций
     * @return сортированый список
     *
     * */
    public List<Organization>sortList() {
        this.structureList.sort(new Comparator<Organization>() {
            @Override
            public int compare(Organization o1, Organization o2) {
                return ((o1.getOrgName()+o1.getDepName()+o1.getSubdevName())
                        .compareTo(o2.getOrgName()+o2.getDepName()+o2.getSubdevName()));

            }
        });
        return this.structureList;
    }
    public List<Organization>backSort() {
        this.structureList.sort(new Comparator<Organization>() {
            @Override
            public int compare(Organization o1, Organization o2) {
                return ((o2.getOrgName()+o2.getDepName()+o2.getSubdevName())
                        .compareTo(o1.getOrgName()+o1.getDepName()+o1.getSubdevName()));

            }
        });
        return this.structureList;
    }

    /**
    *Метод для отображения
    *списка организаций
    */
    public void showList(){
        for(Organization org:this.structureList) {
            System.out.println(org.toString());
        }
    }
/**
 * получаем список организаций
 * @return - список structureList;
 * */
    public ArrayList<Organization> getStructureList() {
        return structureList;
    }
}
