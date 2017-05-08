package ru.chedmitriy.IteratorAndDoubleArray.evenSearching;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SearchForEvenValuesTest {
    @Test
    public void whenElementWasIterated() {
    int [] arr ={1,2,3,4,5,6,7,8,9,10,11,12,13,16,20,35,44};
        SearchForEvenValues e = new SearchForEvenValues(arr);
        while (e.hasNext()) {
            assertTrue(e.next() % 2 == 0);
        }
    }

    @Test
    public void whenCheckTheNextElementWasChecked(){
        int[] ar = {2};
        SearchForEvenValues searchForEvenValues = new SearchForEvenValues(ar);
        searchForEvenValues.next();
        boolean value = searchForEvenValues.hasNext();
        assertThat(value,is(false));
    }
}