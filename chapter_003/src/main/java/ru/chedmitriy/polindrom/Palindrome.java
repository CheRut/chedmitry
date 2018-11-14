package ru.chedmitriy.polindrom;



import ru.chedmitriy.bank.ConsoleIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author Dmitry Cherutsa on 08.01.2017.
 * @version $Id$
 * @project junior
 * @since 0.1
 */
public class Palindrome {
    /**
     * .
     * Использую собственный класс для
     * вывода текста в консоль
     */
    ConsoleIO cIO = new ConsoleIO();
    char[] word;


    /**
     * .
     * Метод предлагает пользователю
     * ввести в консоль слово из пяти букв.
     * Если введенное слово полиндром-
     * метод возвращает true,
     * в противном случае вернется false.
     * Если пользователь введет слово длиной
     * отличной от 5-ти символов
     * выпадет исключение с сообщением
     * об этом
     *
     * @return - возвращает true/false в
     * соответствии с описаной выше логикой
     */
    public boolean isPalindrome(String inputLine) throws IOException {
        boolean isPal = false;
        word = inputLine.toLowerCase().toCharArray();
        if (word.length == 5) {
            for (int i = 0; i < word.length; i++) {
                if (word[i] != word[word.length - 1 - i]) {
                    isPal = false;
                    break;
                } else {
                    isPal = true;
                }
            }
        } else {
            throw new IOException("Ошибка,длина "
                    + "слова должна состоять из пяти букв!");
        }
        cIO.println(isPal);
        return isPal;

    }
/**.
 *  Данный метод нужен для
 *  ввода анализируемой строки
 *  */
    public String wordsCheckerConsole() throws IOException {
        cIO.println("Введите слово из пяти букв: ");
        String checkingLine;

            try (BufferedReader br
                         = new BufferedReader(new InputStreamReader(System.in))) {
                checkingLine = br.readLine();
                isPalindrome(checkingLine);
                }
        return checkingLine;
    }


}