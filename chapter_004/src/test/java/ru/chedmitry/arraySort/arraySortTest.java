package ru.chedmitry.arraySort;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.collections.arraySort.SortUser;
import ru.chedmitriy.collections.arraySort.User;

import javax.jws.soap.SOAPBinding;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class arraySortTest {
    SortUser sortUser;
    List<User> users;

    @Before
    public void fillList() {
        sortUser = new SortUser();
        users = new ArrayList<>();
        users.add(new SortUser("Dmitry", 29));
        users.add(new SortUser("Andrey", 26));
        users.add(new SortUser("Nikita", 44));
        users.add(new SortUser("Sergey", 23));
        users.add(new SortUser("Denis", 29));
        users.add(new SortUser("Viktor", 25));
        users.add(new SortUser("Evgeniy", 37));
        users.add(new SortUser("Stanislav", 22));
    }
/**
 * Переведем наш TreeSet в ArrayList<User>
 *     затем,проверим соответствие значений
 *     */
    @Test
    public void testSorting() {
        ArrayList<User> us = new ArrayList<>();
      List<User> userList = sortUser.sortHash(users);
        String expected = "Stanislav";
        for (User user : userList)
            us.add(user);
        //assertThat(us.get(0).getName(), is(expected));
    }
}
