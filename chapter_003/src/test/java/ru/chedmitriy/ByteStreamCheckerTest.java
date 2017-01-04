package ru.chedmitriy;

import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.byteStreamChecker.ByteStreamChecker;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Dmitry Cherutsa on 01.01.2017.
 * @version $Id$
 * @project junior
 * @since 0.1
 */
public class ByteStreamCheckerTest {
    ByteStreamChecker byteStreamChecker;
    InputStream inputstreamTrueEven;
    InputStream inputStreamFalseEven;
    /**.
     * FILEINNAME - путь чтения файла
     * */
    final String FILEINNAMEEVEN = "src/main/resources/evenTrueNumbers.txt";
    final String FILEINNAMENOTEVEN = "src/main/resources/evenFalseNumbers.txt";

    @Before
    public void init() throws FileNotFoundException {
        byteStreamChecker =  new ByteStreamChecker();
        inputstreamTrueEven = new FileInputStream(new File(FILEINNAMEEVEN).getAbsolutePath());
        inputStreamFalseEven =new FileInputStream(new File(FILEINNAMENOTEVEN).getAbsolutePath());
    }
    @Test
    public void tryStream() throws IOException {
        boolean evenNumber = true;
       assertEquals(evenNumber,byteStreamChecker.isNumber(inputstreamTrueEven));
        assertNotEquals(evenNumber,byteStreamChecker.isNumber(inputStreamFalseEven));
    }
}
