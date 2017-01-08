package ru.chedmitriy;

import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.polindrom.PolyndromeBrowser;

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
 * PolyndromeBrowser
 *
 */
public class WordsCheckerTest {
    PolyndromeBrowser pB;
    BufferedReader br;

    @Before
    public void initTest() {
        pB = new PolyndromeBrowser();
    }

/**.
 * Тестирую true результат работы
 * метода при передаче в него слова-полиндрома
 * из пяти букв со смешанным регистром
 * */
   @Test
    public void wordCheckerTrueTest() throws Exception {
       /**.
        * Эмитирую ввод с клавиатуры
        * */
       ByteArrayInputStream in = new ByteArrayInputStream("РоТор".getBytes());
              System.setIn(in);
       /**.
        * Вводимое слово Ротор.Результаом проверки должно быть
        * true*/
        assertTrue(pB.wordsCheckerConsole());

   }
    /**.
     * Тестирую false результат работы
     * метода при передаче в него слова- не полиндрома
     * из пяти букв.
     * */
    @Test
    public void wordCheckerFalseTest() throws Exception {
        /**.
         * Эмитирую ввод с клавиатуры
         * */
        ByteArrayInputStream in = new ByteArrayInputStream("савок".getBytes());
        System.setIn(in);
        /**.
         * Вводимое слово савок.Результатаом проверки должно быть
         * false
         * */
        assertFalse(pB.wordsCheckerConsole());

    }
    /**.
     * Тестирую false результат работы
     * метода при передаче в него слова- полиндрома
     * из 4 букв.
     * */
    @Test(expected = Exception.class)
    public void wordCheckerExceptTest() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("асса".getBytes());
        System.setIn(in);
        /**.
         * Вводимое слово асса.Результатом проверки будет
         * исключение и false ,так как слово из 4-х букв.
         */
        assertFalse(pB.wordsCheckerConsole());

    }
}
