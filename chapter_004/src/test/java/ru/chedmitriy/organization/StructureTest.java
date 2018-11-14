package ru.chedmitriy.organization;

import org.junit.Test;

import java.util.*;
/**
 * класс Тест
 * добавляем организации,
 * выводим список
 * */
public class StructureTest {

    @Test
    public void structureListFill() throws Exception {
        Structure structure = new Structure();
        structure.getStructureList().addAll(Arrays.asList(
                new Organization("K1", "SK1", "SSK1"),
                new Organization("K1", "SK1", ""),
                new Organization("K1", "SK2", ""),
                new Organization("K1", "SK2", "SSK1"),
                new Organization("K1", "SK1", "SSK2"),
                new Organization("K1", "", ""),

                new Organization("K2", "SK2", "SSK2"),
                new Organization("K2", "SK1", "SSK1"),
                new Organization("K2", "SK2", ""),
                new Organization("K2", "SK1", ""),
                new Organization("K2", "SK1", "SSK2"),
                new Organization("K2", "SK2", "SSK1"),
                new Organization("K2", "", "")));

                structure.sortList();
                structure.showList();
        System.out.println("меняем порядок");
        structure.backSort();
        structure.showList();



    }

}