package ru.chedmitry.arraySort;



import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.collections.arraySort.SortUser;
import ru.chedmitriy.collections.arraySort.User;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class arraySortTest {
    private SortUser sortUser;
    private List<User> users = new ArrayList<>();

    @Before
    public void fillList() {
        sortUser = new SortUser();
        users = new ArrayList<>();
        users.add(new User("Dmitry", 29));
        users.add(new User("Andrey", 26));
        users.add(new User("Aleksandr", 44));
        users.add(new User("Oleg", 23));
        users.add(new User("Aleksey", 29));
        users.add(new User("Anatoliy", 25));
        users.add(new User("Evgeniy", 37));
        users.add(new User("Stanislav", 22));
    }
    /**
     * Переведем наш TreeSet в ArrayList<User>
     * затем,проверим соответствие значений
     *     */
    @Test
    public void testSorting() {
        Set<User> userList;
        String expected = "Stanislav";
        userList = sortUser.sort(users);
        assertThat(userList.iterator().next().getName(), is(expected));
    }


    @Test
    public void testWhenSortingByHashCode() {
        List<User> userList;
        userList = sortUser.sortHash(users);
        assertTrue(userList.get(0).hashCode()<userList.get(1).hashCode());
        assertTrue(userList.get(1).hashCode()<userList.get(2).hashCode());
        assertTrue(userList.get(2).hashCode()<userList.get(3).hashCode());
        assertTrue(userList.get(3).hashCode()<userList.get(4).hashCode());



    }
    @Test
    public void testWhenSortingByNameLength() {
        List<User> userList;
        userList = sortUser.sortLength(users);
        assertTrue(userList.get(0).getName().length() <= userList.get(1).getName().length());
        assertTrue(userList.get(1).getName().length() <= userList.get(2).getName().length());
        assertTrue(userList.get(2).getName().length() <= userList.get(3).getName().length());
        assertTrue(userList.get(3).getName().length() <= userList.get(4).getName().length());

    }
}
