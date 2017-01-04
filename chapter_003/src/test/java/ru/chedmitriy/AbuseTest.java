package ru.chedmitriy;

import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.abusesDropping.Abuse;

import java.io.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Dmitry Cherutsa on 04.01.2017.
 * @version $Id$
 * @project junior
 * @since 0.1
 */
public class AbuseTest {
    /**.
     * out - параметр
     * выходного потока
     * */
    OutputStream out;
    /**.
     * FILEOUTNAME - путь записи файла
     * */
    final String FILEOUTNAME = "src/main/resources/abusesOut.txt";
    /**.
     * FILEINNAME - путь чтения файла
     * */
    final String FILEINNAME = "src/main/resources/abuses.txt";
    /**.
     * параметр класса Abuse для
     * доступа к методу
     * dropAbuse
     * */
    Abuse ab;

    /**.
     * массив "ненужных" строк
     * */
    String[]abuse;
    /**
     * in - параметр входного
     * потока для чтения
     * строк файла
     * */
    InputStream in;
    /**
     * in - параметр входного
     * потока для чтения
     * строк из нового файла
     * и проверки значений
     * */
    InputStream inReadOut;
    /**
     * параметр для чтения
     * байтов
     * */
    int readInt;
    /**
     * изменяемая строка
     * */
    StringBuilder s = new StringBuilder();


@Before
public void init() throws FileNotFoundException {
     ab = new Abuse();
     abuse = new String[] {"two", "four", "five", "eight", "ten","seven"};
     in= new FileInputStream(new File(FILEINNAME).getAbsolutePath());
     out = new FileOutputStream(new File(FILEOUTNAME).getAbsolutePath());
     inReadOut = new FileInputStream(new File(FILEOUTNAME).getAbsolutePath());
}
    /**
     * в данном тесте
     * я использую метод dropAbuse,чтобы
     * перезаписать файл abusesOut.txt
     * читаю его,вывожу строку
     * и сравниваю ее с true-параметром
     * и false-параметром*/
    @Test
    public void dropAbuseTest() throws IOException {
        String actualTrue = "onethreesixnine";
        String actualFalse = "onetwothreesixnine";
        ab.dropAbuses(in,out,abuse);
        try {
            while ((readInt = inReadOut.read()) != -1) {
                s.append((char) readInt);
            }
    }catch(IOException ex){
                System.out.println("Ошибка ввода/вывода");
                ex.printStackTrace();
            }

        assertTrue(actualTrue.equals(s.toString()));
        assertFalse(actualFalse.equals(s.toString()));
    }

}
