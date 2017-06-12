package ru.chedmitriy.collectionsPro.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    private Calendar birthd = new GregorianCalendar(1987,8,3);
    private User first;
    private User second;
    private Set<User> userMap;
    @Before
    public void init(){
        userMap = new HashSet<>();
        first = new User("Dmitry",2,birthd);
        second  = new User("Dmitry",2,birthd);
    }
    @Test
    public void map(){
        userMap.add(first);
        userMap.add(second);
        System.out.println(first.hashCode());
        System.out.println(second.hashCode());
        assertThat(first,is(second));
    }
    

}
