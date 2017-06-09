package ru.chedmitriy.collectionsPro.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void map(){
        Calendar birthd = new GregorianCalendar(1987,8,3);
        User first = new User("Dmitry",2,birthd);
        User second  = new User("Dmitry",2,birthd);
        Set<User> userMap = new HashSet<>();
        userMap.add(first);
        userMap.add(second);
        System.out.println(first.hashCode());
        System.out.println(second.hashCode());
        assertThat(first,is(second));


    }

}