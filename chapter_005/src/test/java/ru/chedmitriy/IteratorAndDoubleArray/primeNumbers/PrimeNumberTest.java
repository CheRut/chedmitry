package ru.chedmitriy.IteratorAndDoubleArray.primeNumbers;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrimeNumberTest {
   @Test
    public void whenElementWasIterated() {
        int[] array = {4,5,6,2,87,9};
       PrimeNumber e = new PrimeNumber(array);
       e.next();
       e.next();
       boolean value=e.hasNext();
       assertThat(value,is(false));
    }
}