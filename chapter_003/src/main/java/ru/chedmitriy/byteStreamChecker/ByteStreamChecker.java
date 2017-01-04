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
     * PATH - путь к
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
        String s;
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
            try  {
                while ((s = br.readLine()) != null) {
                    if (Integer.valueOf(s) % 2 == 0 && !s.equals("0")) {
                        evenNumb = true;
                        cIO.print(s + " - четное: " + evenNumb);
                        cIO.println("");
                    } else {
                        evenNumb = false;
                        cIO.print(s + " - нечетное: " + evenNumb);
                        cIO.println("");
                    }
                }
            } catch(FileNotFoundException fex) {
                cIO.println(fex.toString());
            }
                finally {
                    try { br.close();
                    } catch(IOException iex){
                   cIO.println(iex.toString());
                }
            }
    return evenNumb;
    }


}



