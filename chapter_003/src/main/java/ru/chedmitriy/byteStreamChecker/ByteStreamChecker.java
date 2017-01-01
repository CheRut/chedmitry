package ru.chedmitriy.byteStreamChecker;


import ru.chedmitriy.chess.usage.ConsoleIO;

import java.io.*;

/**.
 * @author Dmitry Cherutsa on 10.12.2016.
 * @version $Id$
 * @project junior
 * @since 0.1
 */
public class ByteStreamChecker {
    /**.
     * Для вывода текста в консоль
     * использую собствееный класс
     * */
    ConsoleIO cIO = new ConsoleIO();

    /**.
     * PATH - путьк
     * конкретному файлу
     * 'numbers.txt'
     * в папке resources
     *
     * */
     public final String PATH = "chapter_003/src/main/resources/numbers.txt";

/**.
 * Данный метод,принимает параметр
 * -входной поток,после чего,обрабатывает его
 * и принимает на выходе true/false
 * параметрв зависимости от четности
 * чисел входного потока
 *
 * @param in -входной поток-текстовый файл
 * @return значение true,при определении четного числа
 * и false-при определении нечетного числа
 * */
public boolean isNumber(InputStream in) throws IOException{
        boolean evenNumb = false;

            try (BufferedReader  br = new BufferedReader(new InputStreamReader(in))) {
                String s;
                while((s = br.readLine())!= null) {
                    if (Integer.valueOf(s) % 2 == 0 && Integer.valueOf(s) !=0 ) {
                        evenNumb = true;
                        cIO.print(s + " - четное: " + evenNumb);
                        cIO.println("");
                    } else {
                        evenNumb = false;
                        cIO.print(s + " - нечетное: " + evenNumb);
                        cIO.println("");
                    }
                }


            }
    return evenNumb;
    }

    public static void main(String[] args) throws IOException {
        ByteStreamChecker byteStreamChecker =  new ByteStreamChecker();
        InputStream inputstream = new FileInputStream(new File(byteStreamChecker.PATH).getAbsolutePath());
        byteStreamChecker.isNumber(inputstream);
    }
}



