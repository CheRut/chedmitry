package ru.chedmitriy.extsort;



import java.io.*;

/**
 * @author Dmitry Cherutsa on 05.01.2017.
 * @version $Id$
 * @project junior
 * @since 0.1
 */
public class ReadFile {
    /**
     * .
     * исходный файл
     */
    private RandomAccessFile sourceStream;
    /**
     * .
     * Конечный ,отсортированный файл
     */
    private RandomAccessFile distStream;
    /**
     * вспомагательный файл
     */
    private RandomAccessFile firstHalfOfSource;
    /**
     * .
     * вспомагательный файл
     */
    private RandomAccessFile secondHalfOfSource;
    /**.
     * Счетчик строк первого файла
     * */
    private  int firstFileLinesCounter = 0;
    /**.
     * Счетчик строк второго файла
     * */
    private int secFileLinesCounter = 0;


    /**
     * .
     * Метод разбивает
     * файл на два
     * вспомагательных
     * файла
     * в каждый из файлов записываются
     * знач
     */
    public void fileSharing(RandomAccessFile sourceStream,
                            RandomAccessFile firstHalfOfSource,
                            RandomAccessFile secondHalfOfSource) throws IOException {

        String line;
        /**
         * Параметр объема считанных строк
         * */
        byte weight = 0;
        try {

            /** Определяю размер
             *  исходного файла
             *
             * */
            long fileSize = sourceStream.length();
            /**
             * определяю размер
             *  одного из вспомогательных файлов
             * */
            long firstFileSize = fileSize / 2;
            if (fileSize <= 1) {
                return;
            } else {
                /**.
                 * если прочитанная строка не NULL
                 *  начинаю цикл
                 *  */
                while ((line = sourceStream.readLine()) != null) {
                    /**до тех пор пока параметр
                     *  считанных символов  меньше объема первого файла,
                     *  записываю в него байты с исходника*/
                    if (weight < firstFileSize) {
                        this.firstFileLinesCounter++;
                        firstHalfOfSource.write(line.getBytes());
                        firstHalfOfSource.write("\n".getBytes());
                        weight += line.getBytes().length;
                        secondHalfOfSource.seek(0);

                        /**остальное отдаю во второй
                         *  вспомогательный файл*/
                    } else if (weight >= firstFileSize && weight < fileSize) {
                        this.secFileLinesCounter++;
                        secondHalfOfSource.write(line.getBytes());
                        secondHalfOfSource.write("\n".getBytes());
                        weight += line.getBytes().length;
                    }
                }

            }

            sortinglines(firstHalfOfSource, firstFileLinesCounter);
            sortinglines(secondHalfOfSource, secFileLinesCounter);
            sourceStream.close();
            firstHalfOfSource.close();
            secondHalfOfSource.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * .
     * Метод сравнивает строки из двух файлов
     * и заносит их в конечный файл distFile
     * Когда в одном из файлов прочитаются все строки,
     * в конечный файл добавятся остальные строки из второго файла
     */
    public void merge(RandomAccessFile distStream,
                      RandomAccessFile firstHalfOfSource,
                      RandomAccessFile secondHalfOfSource) throws IOException {
        this.firstHalfOfSource = firstHalfOfSource;
        this.secondHalfOfSource = secondHalfOfSource;
        this.distStream = distStream;

        String line1 = firstHalfOfSource.readLine();
        String line2 = secondHalfOfSource.readLine();
        firstHalfOfSource.seek(0);
        secondHalfOfSource.seek(0);

        while (((line1 != null
                && (line2  != null)))) {
            if (line1.length() <= line2.length()
                    && this.firstFileLinesCounter > 0) {
                distStream.write(line1.getBytes());
                distStream.writeUTF(System.getProperty("line.separator"));
                removeLine(firstHalfOfSource, line1);
                this.firstFileLinesCounter--;

            } else if (line2.length() <= line1.length()
                    && this.secFileLinesCounter > 0) {
                distStream.write(line2.getBytes());
                distStream.writeUTF(System.getProperty("line.separator"));
                removeLine(secondHalfOfSource, line2);
                this.secFileLinesCounter--;
            }
            if (this.firstFileLinesCounter == 0
                    && this.secFileLinesCounter > 0) {
                while (secFileLinesCounter > 0) {
                    distStream.write(line2.getBytes());
                    distStream.writeUTF(System.getProperty("line.separator"));
                    this.secFileLinesCounter--;
                }
            }
            if (this.firstFileLinesCounter > 0
                    && this.secFileLinesCounter == 0) {
                while (secFileLinesCounter > 0) {
                    distStream.write(line1.getBytes());
                    distStream.writeUTF(System.getProperty("line.separator"));
                    this.secFileLinesCounter--;
                }
            }
        }

    }

    /**.
     * Метод,создает  массив размером
     * количества строк из считанного ранее файла
     * */
public void sortinglines(RandomAccessFile raf, int size) throws IOException {
    String line;
    String[] sortered = new String[size];
    try {
        while ((line = raf.readLine()) != null) {
            for (int i = 0; i < sortered.length; i++) {
               sortered[i] = line;
            }

        }
        for (int i = 0; i < sortered.length; i++) {
            for (int j = 0; j < sortered.length - 1 - i; j++) {
                if (sortered[j].length() > sortered[j + 1].length()) {
                    String str = sortered[j];
                    sortered[j] = sortered[j + 1];
                    sortered[j + 1] = str;
                }
            }
        }
        raf.seek(0);
        for (int i = 0; i < sortered.length; i++) {
            raf.writeUTF(sortered[i]);
        }

    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
    /**
     * .
     * в процессе сортировки
     * данный метод удаляет
     * строку,занесенную
     * в файл distFile
     */
    public static void removeLine(RandomAccessFile raf, String line)
            throws IOException {
        raf.seek(raf.getFilePointer() - (line.length() + 1));
        System.out.println(raf.getFilePointer());
        try {
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                chars[i] = '\0';
                raf.write(chars[i]);
            }
            raf.seek(raf.getFilePointer() + 1);
            System.out.println(raf.getFilePointer());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
/**.
 * Главный метод  добавляет сортированный список строк
 * из исходного файла source в конечный dist
 * */
    public void sort(File source, File dist) {
        File fstHalf = null;
        File secHalf = null;
        try {
            fstHalf = File.createTempFile("fst",
                    ".txt",
                    new File(System.getProperty("java.io.tmpdir")));
            secHalf = File.createTempFile("sec",
                    ".txt",
                    new File(System.getProperty("java.io.tmpdir")));
            this.sourceStream = new RandomAccessFile(source, "r");
            this.distStream = new RandomAccessFile(dist, "rw");
            this.firstHalfOfSource = new RandomAccessFile(fstHalf, "rw");
            this.secondHalfOfSource = new RandomAccessFile(secHalf, "rw");
            fileSharing(sourceStream, firstHalfOfSource, secondHalfOfSource);
            merge(distStream, firstHalfOfSource, secondHalfOfSource);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
