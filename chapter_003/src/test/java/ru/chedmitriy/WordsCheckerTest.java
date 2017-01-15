package ru.chedmitriy;

import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.polindrom.Palindrome;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Dmitry Cherutsa on 08.01.2017.
 *  @version $Id$
 * @project junior
 * @since 0.1
 * В этом классе тестирую
 * методд wordCheckerConsole класса
 * Palindrome
 *
 */
public class WordsCheckerTest {
    Palindrome pB;


    @Before
    public void initTest() {
        pB = new Palindrome();
    }

/**.
 * Тестирую true результат работы
 * метода при передаче в него слова-палиндрома
 * из пяти букв со смешанным регистром
 * */
   @Test
    public void wordCheckerTrueTest() throws Exception {
     String in = "РоТоР";

        assertTrue(pB.isPalindrome(in));

   }
    /**.
     * Тестирую false результат работы
     * метода при передаче в него слова- не полиндрома
     * из пяти букв.
     * */
    @Test
    public void wordCheckerFalseTest() throws Exception {

        String in = "савок";

        assertFalse(pB.isPalindrome(in));

    }
    /**.
     * Тестирую false результат работы
     * метода при передаче в него слова- полиндрома
     * из 4 букв.
     * */
    @Test(expected = Exception.class)
    public void wordCheckerExceptTest() throws Exception {
        String in = "АннА";
        assertFalse(pB.isPalindrome(in));

    }
}
