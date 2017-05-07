package ru.chedmitriy.collections.organization;

/**
 * Главный класс - несет в
 * себе информацию об организации,
 * вклюяает вс себя отделы и
 * отделения
 * */
public class Organization {
    /**
     * название
     * организации
     * */
    private final String orgName;
    /**
     * название отдела
     * */
    private final  String depName;
    /**
     * название отделения
     * */
    private final String subdevName;
    /**
     *
     * Конструктор - структура
     * организации
     * @param orgName - название организации
     * @param depName - название отдела
     * @param subdevName - название отделения
     *
     * */
    public Organization(String orgName, String depName, String subdevName) {
        this.orgName = orgName;
        this.depName = depName;
        this.subdevName = subdevName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (orgName != null ? !orgName.equals(that.orgName) : that.orgName != null) return false;
        if (depName != null ? !depName.equals(that.depName) : that.depName != null) return false;
        return subdevName != null ? subdevName.equals(that.subdevName) : that.subdevName == null;
    }

    @Override
    public int hashCode() {
        int result = orgName != null ? orgName.hashCode() : 0;
        result = 31 * result + (depName != null ? depName.hashCode() : 0);
        result = 31 * result + (subdevName != null ? subdevName.hashCode() : 0);
        return result;
    }
/**
 * каждый элемент организации
 * будет отделен символом '/' при
 * отображениисписка
 *
 * */
    @Override
    public String toString() {
        return orgName +
                '/' +depName +
                '/' +subdevName+'/';

    }
}
