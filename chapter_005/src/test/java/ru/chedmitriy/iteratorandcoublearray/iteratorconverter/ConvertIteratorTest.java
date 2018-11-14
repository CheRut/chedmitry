package ru.chedmitriy.iteratorandcoublearray.iteratorconverter;

import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.junit.Assert.assertArrayEquals;


public class ConvertIteratorTest {


    @Test
    public void testIterator() {
        Iterator<Integer> i1 = Arrays.asList(4, 2, 0, 4, 6, 4, 9).iterator();
        Iterator<Integer> i2 = Arrays.asList(0, 9, 8, 7, 5).iterator();
        Iterator<Integer> i4 = new ArrayList<Integer>().iterator();
        Iterator<Integer> i3 = Arrays.asList(1, 3, 5, 6, 7, 0, 9, 8, 4).iterator();
        Iterator<Iterator<Integer>> iterator = Arrays.asList(i1, i2, i4, i3).iterator();
        IteratorConverterInterface iteratorConverterInterface = new IteratorConverterImplement();
        Iterator<Integer> convertedIterator = iteratorConverterInterface.convert(iterator);
        while (convertedIterator.hasNext()) {
            System.out.print(convertedIterator.next() + " ");
        }

   }
}