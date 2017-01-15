package ru.chedmitriy.extSort;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Dmitry Cherutsa on 05.01.2017.
 * @version $Id$
 * @project junior
 * @since 0.1
 */
public class ReadFile {
        /**.
         * исходный файл
         * */
        RandomAccessFile source;
        /**.
         * Конечный ,отсортированный файл
         * */
        RandomAccessFile distFile;
        /**
         *вспомагательный файл
         * */
       private RandomAccessFile firstOptionalFile;
        /**.
         * вспомагательный файл
         * */
        RandomAccessFile secondOptionalFile ;
        /**.
        * исходный файл
        * */

                        /**.
        * выбираем параметр доступа
         * rw - чтение и запись*/
        String accesMode = "rw";
    int frstPositions = 0;
    int secPositions = 0;

    public ReadFile() throws IOException {
    }


    /**.
         * Метод разбивает
         * файл на два
         * вспомагательных
         * файла
         * в каждый из файлов записываются
         * знач*/
        public void fileSharing() throws IOException {

            
            String line;
            /**
             * Параметр объема считанных строк
             * */
            byte weight = 0;

            try {
                /**
                 * Указываю пути к файлам
                 *
                 * */
               // source = new RandomAccessFile(new File();
                firstOptionalFile = new RandomAccessFile(new File(System.getProperty("java.io.tmpdir")),"rw");
                secondOptionalFile = new RandomAccessFile(new File("chapter_003/src/main/resources/optionalSec.txt"),"rw");
                distFile = new RandomAccessFile(new File("chapter_003/src/main/resources/distFile.txt"),"rw");
                /**.
                * Определяю размер файла
                 * исходного
                * */
                long fileSize = source.length();
                /**
                 * определяю размер
                 *  дного из вспомогательных файлов
                 * */
                long optionFstFileSize = fileSize/2;

                if(fileSize<=1){
                    return;
                }
                else {
                    /**.
                     * если прочитанная строка не NULL
                     *  начинаю цикл
                     *  */
                    while ((line = source.readLine()) != null) {
                            /**до тех пор пока параметр
                            *  считанных символов не меньше объема первого файла,
                            *  записываю в него байты с исходника*/
                        if (weight < optionFstFileSize) {
                            firstOptionalFile.write(line.getBytes());
                            firstOptionalFile.write("\n".getBytes());
                            weight += line.getBytes().length;
                            secondOptionalFile.seek(0);

                            /**остальное отдаю во второй
                             *  вспомогательный файл*/
                        } else if (weight >= optionFstFileSize && weight < fileSize) {
                            secondOptionalFile.write(line.getBytes());
                            secondOptionalFile.write("\n".getBytes());
                            weight += line.getBytes().length;
                        }
                    }
                    /**здесь предполагается разместить метод слияния
                     * двух отсортированных файлов - merge*/
                    merge();
                }
                source.close();
                firstOptionalFile.close();
                secondOptionalFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

/**.
 * Метод сравнивает строки из двух файлов
 * и заносит их в конечный файл distFile
 * */
    public void merge() throws IOException {

        String line1,line2;
        firstOptionalFile.seek(0);
        secondOptionalFile.seek(0);

        while (((line1 = firstOptionalFile.readLine()) != null && (line2 = secondOptionalFile.readLine()) != null)){
            if (line1.length() <= line2.length()) {
                distFile.write(line1.getBytes());
                distFile.writeUTF(System.getProperty("line.separator"));
                removeLine(firstOptionalFile, line1);
            } else {
                distFile.write(line2.getBytes());
                distFile.writeUTF(System.getProperty("line.separator"));
                removeLine(secondOptionalFile, line2);
            }
                }

    }
    /**.
     * в процессе сортировки
     * данный метод удаляет
     * строку,занесенную
     * в файл distFile
     */
    public static void removeLine(RandomAccessFile raf,String line) throws IOException {
        raf.seek(raf.getFilePointer()-(line.length()+1));
        System.out.println(raf.getFilePointer());
        try {
            char[]chars = line.toCharArray();
            for (int i = 0; i <chars.length ; i++) {
                chars[i] = '\0';
                raf.write(chars[i]);
            }
            raf.seek(raf.getFilePointer()+1);
            System.out.println(raf.getFilePointer());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
