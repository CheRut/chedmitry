package ru.chedmitriy.abusesDropping;

import java.io.*;

/**
 * Created by dimsan on 30.12.2016.
 */
public class Abuse {
    /**.
     * USERDIRECTORY -
     *  пользовательская директория
     * 'user.dir'
     * */
    private final String USERDIRECTORY = System.getProperty("user.dir");
    /**.
     * PATH - путьк
     * конкретному файлу
     * 'numbers.txt'
     * в папке resources
     *
     * */
    private final String PATH = "Chapter_003/src/main/resources/abuses.txt";



    /**.
     * Метод 'readFile()'-информирует
     * о содержимом файла-входящего потока
     * выводя содержимое в консоль*/
    void readFile(){
        try {
            InputStream in = new FileInputStream(new File(USERDIRECTORY,PATH));
            int number = in.read();
            char fileContent;
            System.out.print("Строка,записанная в файле: ");
            while (number != -1) {
                fileContent = (char) number;
                System.out.print(fileContent);
                number = in.read();
            }
            System.out.println();
            in.close();
        }catch (IOException iOE){
            iOE.printStackTrace();
        }
    }
    // запись в файл используя OutputStream
    public void write(String st) throws IOException {
        // инициализируем поток для вывода данных
        // что позволит нам записать новые данные в файл
      FileOutputStream  outputStream = new FileOutputStream(PATH);
        // передаем полученную строку st и приводим её к byte массиву.
        outputStream.write(st.getBytes());
        // закрываем поток вывода
        // только после того как мы закроем поток данные попадут в файл.
        outputStream.close();
    }

    public static void main(String[] args) throws IOException {
        Abuse abuseStream = new Abuse();
        abuseStream.readFile();
        abuseStream.write("kjkjkjkjkj");
    }
}
