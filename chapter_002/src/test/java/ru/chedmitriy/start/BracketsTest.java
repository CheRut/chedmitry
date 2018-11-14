package ru.chedmitriy.start;

import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.bracketschecker.BracketsChecker;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

/**
 * Created by dimsan on 30.12.2016.
 */
public class BracketsTest {
    BracketsChecker bc;
    String s1;

    @Before
    public void variantsOfStrings() {
        bc = new BracketsChecker();


    }

    @Test
    public void closeOpentest() {
        s1 = ")(";
        assertFalse(bc.bracketsOpenAndClose(s1));

    }
    @Test
    public void openClosetest() {
        s1 = "((()))";
        assertTrue(bc.bracketsOpenAndClose(s1));

    }
}
