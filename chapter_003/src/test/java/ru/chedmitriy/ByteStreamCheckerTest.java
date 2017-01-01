package ru.chedmitriy;

import org.junit.Test;
import ru.chedmitriy.byteStreamChecker.ByteStreamChecker;

import java.io.*;

/**
 * @author Dmitry Cherutsa on 01.01.2017.
 * @version $Id$
 * @project junior
 * @since 0.1
 */
public class ByteStreamCheckerTest {
    /**.
     * Обрабатываю также исключение
     * FileNotFoundException
     * */

    @Test (expected = FileNotFoundException.class)
    public void tryStream() throws IOException {
        ByteStreamChecker byteStreamChecker =  new ByteStreamChecker();
        InputStream inputstream = new FileInputStream(new File(byteStreamChecker.PATH).getAbsolutePath());
        byteStreamChecker.isNumber(inputstream);
    }
}
