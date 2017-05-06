package ru.chedmitriy.collections.organization;

import java.util.Comparator;

class OrganizationStructureComparator implements Comparator<Organization> {
    @Override
    public int compare(Organization o1, Organization o2) {

        return o1.getName().compareTo(o2.getName());
    }
}
