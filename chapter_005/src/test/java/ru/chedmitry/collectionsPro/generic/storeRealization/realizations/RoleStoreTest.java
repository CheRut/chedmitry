package ru.chedmitry.collectionsPro.generic.storeRealization.realizations;

import org.junit.Before;
import org.junit.Test;
import ru.chedmitry.collectionsPro.generic.storeRealization.exeptions.WhenObjectNotFoundException;
import ru.chedmitry.collectionsPro.generic.storeRealization.objects.Role;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {
    RoleStore rs;
    @Before
    public void init() {
        rs = new RoleStore(10);
        rs.add(new Role("student"));
        rs.add(new Role("junior"));
        rs.add(new Role("middle"));
    }
    @Test
    public void add() throws Exception {
        rs.add(new Role("senior"));
        assertThat(rs.getById("4").getName(),is("senior"));
    }
    @Test
    public void update() throws Exception {
        Role tech = new Role("senior");
        rs.update(rs.getById("2"),tech);
        assertThat(rs.getById("2").getName(),is("senior"));
    }
    @Test
    public void delete() throws WhenObjectNotFoundException {
       rs.delete("1");
       assertNull(rs.getObjects()[0]);
    }
    @Test
    public void getById() throws Exception {
        Role role = rs.getById("1");
        assertThat(role.getName(),is("student"));
    }
}