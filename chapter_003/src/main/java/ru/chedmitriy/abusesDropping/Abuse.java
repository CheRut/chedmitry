package ru.chedmitriy.abusesdropping;

import java.io.*;

/**
 * Created by dimsan on 30.12.2016.
 */
public class Abuse {
/**.
 * Класс StringBuilder
 * позволяет изменять
 * строку,не создавая при этом новой строки,
 * в отличии от String, где любое изменение строки приводит
 * к созданию новой строки со значением измененной старой строки.
 * При этом старая строка остается висеть в памяти,пока ее не уберет
 * уборщик мусора.
 * В данном примере выбар пал на StringBuilder ввиду
 * множественных конкатинаций строк
 * */
    public StringBuilder stringBuilder = new StringBuilder();

    /**.
     * 'c' - символьная переменная
     * значение ее принимается как приведенное
     * целочисленное значение
     * */
    char c;
    /**.
     * параметр 't' - принимает
     * входящий поток*/
    int t;
    /**
     * .
     * path - путь к
     * конкретному файлу
     * 'numbers.txt'
     * в папке resources
     */
    public final String path = "chapter_003/src/main/resources/abuses.txt";
    /**
     * .
     * pathout - путь
     * в место сохранения файла
     *
     */
    public final String pathout = "chapter_003/src/main/resources/abusesOut.txt";

    /**
     * .
     * Метод 'dropAbuse'- удаляет из
     * открытого файла слова,определенные
     * массивом abuses
     * и записывает полученные значения в
     * новый файл.
     * @param in - входной поток - исходный файл
     * @param out - выходной поток - конечный файл
     * @param abuse - массив слов,которые необходимо
     *               убрать из исходного файла.
     */
    public void dropAbuses(InputStream in, OutputStream out, String[] abuse)
            throws IOException {
        try (InputStreamReader inputStreamReader = new  InputStreamReader(in);
             OutputStreamWriter outputWriter = new OutputStreamWriter((out))) {
            while ((t = inputStreamReader.read()) != -1) {
                c = (char) t;
                stringBuilder.append(c);
                for (String ab : abuse) {
                    int start = stringBuilder.indexOf(ab);
                    if (start != -1) {
                        stringBuilder.delete(start, start + ab.length());
                    }
                }

            }
            outputWriter.write(stringBuilder.toString());
        }
    }
  
}
