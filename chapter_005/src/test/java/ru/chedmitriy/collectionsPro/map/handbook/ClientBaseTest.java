package ru.chedmitriy.collectionsPro.map.handbook;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by d1msan on 18.06.2017.
 */
public class ClientBaseTest {


    @Test
    public void insert() throws Exception {
        ClientBase cB = new ClientBase(5);
        cB.insert("first","one");
        cB.insert("second","two");
        cB.insert("third","three");
        cB.insert("third","3");
        cB.insert("five","3");
        for (int i = 0; i <cB.addressBook.length ; i++) {
            if(cB.addressBook[i]!=null)
                System.out.println(cB.addressBook[i].getKey()+" - "+cB.addressBook[i].getValue());
        }
    }
    @Test
    public void get() throws Exception {
        ClientBase cB = new ClientBase(5);
        cB.insert("first","one");
        cB.insert("second","two");
        cB.insert("third","three");
        assertThat(cB.get("first"),is(cB.addressBook[0].getValue()));
    }

    @Test
    public void delete() throws Exception {
        ClientBase cB = new ClientBase(5);
        cB.insert("first","one");
        cB.insert("second","two");
        cB.insert("third","three");

        assertTrue(cB.delete("third"));
      //  assertNull(cB.get("third"));
        for (int i = 0; i <cB.addressBook.length ; i++) {
            if(cB.addressBook[i]!=null)
                System.out.println(cB.addressBook[i].getKey()+" - "+cB.addressBook[i].getValue());
        }
    }

}