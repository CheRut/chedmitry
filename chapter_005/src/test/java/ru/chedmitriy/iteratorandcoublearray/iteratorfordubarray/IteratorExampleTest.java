package ru.chedmitriy.iteratorandcoublearray.iteratorfordubarray;

import org.junit.Test;
import ru.chedmitriy.iteratorandcoublearray.iteratorfordobarray.IteratorExample;

public class IteratorExampleTest {

    @Test
    public void whenNextElementChecking() {
        int[][]ar = {{1, 2}, {3, 4}, {5, 6}};
        IteratorExample it = new IteratorExample(ar);
          while (it.hasNext()) {
          System.out.print(it.next() + " ");
      }
    }

}