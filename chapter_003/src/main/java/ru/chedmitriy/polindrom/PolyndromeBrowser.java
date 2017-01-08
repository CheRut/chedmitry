package ru.chedmitriy.polindrom;

import ru.chedmitriy.chess.usage.ConsoleIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Dmitry Cherutsa on 08.01.2017.
 * @version $Id$
 * @project junior
 * @since 0.1
 */
public class PolyndromeBrowser {
    /**.
     * Использую собственный класс для
     * вывода текста в консоль
     * */
    ConsoleIO cIO = new ConsoleIO();
    /**.
     * Создаю объект класса BufferedReader,но
     * не инициализирую его
     * */
    BufferedReader br;
/**.
 * Метод предлагает пользователю
 * ввести в консоль слово из пяти букв.
 * Если введенное слово полиндром-
 * метод возвращает true,
 * в противном случае вернется false.
 * Если пользователь введет слово длиной
 * отличной от 5-ти символов
 * выпадет исключение с сообщением
 * об этом
 * @return - возвращает true/false в
 * соответствии с описаной выше логикой
 * */
    public  boolean wordsCheckerConsole() throws Exception {
    cIO.println("Введите слово из пяти букв: ");

    String word;
        /**.
         * испоьзую  экземпляр класса StringBuilder,
         * куда посимвольно заношу строку сконца
         * */
    StringBuilder line = new StringBuilder();

    boolean isPolyndrome = false;

    try {BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            if ((word = br.readLine()) != null) {
                word = word.toLowerCase();
            }
           if(word.length()==5) {
                for (int k = word.toCharArray().length - 1; k >= 0; k--) {
                    line.append(word.charAt(k));
                }
            if (word.equals(line.toString())) {
                isPolyndrome = true;
            }
        } else {
               throw new Exception("Ошибка!Слоаво должно состоять из 5 букв");
           }
         } catch (IOException ex) {
        ex.printStackTrace();
    }
    finally {
        try {
            if(br!=null)
                br.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    return isPolyndrome;
    }
}
