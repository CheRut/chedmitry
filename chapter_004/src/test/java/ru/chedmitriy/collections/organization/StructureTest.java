package ru.chedmitriy.collections.organization;

import org.junit.Test;

public class StructureTest {
    Structure structure = new Structure();
    @Test
    public void structureListFill() throws Exception {
        Organization org1 = new Organization("K1",new Department("SK2"),new Subdivision("SSK1"));
        Organization org2 = new Organization("K2",new Department("SK1"),new Subdivision("SSK2"));
        Organization org_1 = new Organization("K1",new Department(""),new Subdivision(""));
        Organization org_2 = new Organization("K2",new Department(""),new Subdivision(""));
        Organization org_11 = new Organization("K1",new Department("SK1"),new Subdivision(""));
        Organization org_22 = new Organization("K2",new Department("SK1"),new Subdivision(""));
        Organization org_23 = new Organization("K1",new Department("SK2"),new Subdivision(""));


        structure.getStructureList().add(org1);
        structure.getStructureList().add(org2);
        structure.getStructureList().add(org_1);
        structure.getStructureList().add(org_2);
        structure.getStructureList().add(org_11);
        structure.getStructureList().add(org_22);
        structure.getStructureList().add(org_23);

structure.showOrganizationStructure(structure.getStructureList());




    }

    @Test
    public void showOrganizationStructure() throws Exception {

    }

}