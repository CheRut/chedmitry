package ru.chedmitriy.multithreading.threads.monitor.ex1106;

import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import ru.chedmitriy.multithreading.threads.service.Settings;
import ru.chedmitriy.multithreading.threads.io.InputOutput;
/**
 * junior
 *
 * @author CheDmitry
 * @version 1.0
 * @since 31.10.17
 * В данном классе производится
 * поиск текста в выбранной директории
 */
public class ParallelSearching {

    /**
     * параметр - путь к файлу
     */
    private final String root;
    /**
     * параметр -  искомый текст
     */
    private final String text;
    /**
     * параметр - расширения файллов
     */
    private final List<String> exts;
    /**
     * параметр - списки путей к файлам,
     * в которых найден искомый текст
     */
    private CopyOnWriteArraySet<String> result;

    /**
     * множество файлов однопоточного варианта
     */
    private Set<File> singleThreadResult;

    /**
     * множество файлов многопоточного варианта
     */
    private Set<File> findingFiles;
    /**
     * счетчик файлов с текстом
     */
    public int fCount = 0;

    /**
     * конструктор
     * класса
     *
     * @param root - путь к файлу, типа String
     * @param text - искомый текст, типа String
     * @param exts - список поддерживаемых расширений
     */
    public ParallelSearching(final String root, final String text, final List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
        singleThreadResult = new HashSet<>();
        findingFiles = new HashSet<>();
        result = new CopyOnWriteArraySet<String>();
    }


    /**
     * Получаем расширение файла:
     * если в имени файла есть точка и она не является
     * первым символом в названии файла
     * то вырезаем все знаки
     * начиная с последней точки
     * Далеее находим соответствия
     * со списком расширений
     * если в списке такое расширение файла нашлось
     * возвращаем "1"
     * в противном случае "-1"
     * @param file - проверяемый файл
     * @return - значение типа int
     */
    private  int getFileExtension(File file) {
        String fileName = file.getName();
        for (String extension:exts) {
            if (fileName.lastIndexOf(".") != -1
                    && fileName.lastIndexOf(".") != 0) {
                if (fileName.substring(fileName.lastIndexOf(".")).equals(extension)) {
                    return 1;
                }
            }
        }
        return -1;
    }

    /**
     * получаем множетво
     * файлов указанной
     * директории и вложенных папок
     * @param rootDirectory - корневая директория
     * @return - множество
     */
    private Set<File> getFile(File rootDirectory) {

        //получаем список всех объектов в текущей директории
        File[] list = rootDirectory.listFiles();

        if (list == null  ) {
            new InputOutput().println(" файлы отсутствуют ");

        } else {
            System.out.printf(String.format("%s %s %s \n",
                    "всего в папке найдено",
                    list.length,
                    "файлов;"));
        }
        for(int i = 0; i < list.length; i++) {

            if(list[i].isDirectory()) {
                getFile(list[i]);
            }

                findingFiles.add(list[i]);
            }
        return findingFiles;
    }
    /**
     * проверяем файлы
     * на наличие
     * искомого текста
     *
     * 1.выполняем проверку
     *
     * списка файлов выбранной директории
     * 2.если пустая - выводим сообщение
     * 3.Инициализируем сервис-испонитель
     * для пула потоков
     *
     * 4.Если все проверки прошли, читаем файл
     *
     * 5.выполняем поставленные задачи,ждем
     * завершения
     *
     * 6.ждем завершения не более 2 минут
     *
     *
     */

    public void textParser() {
        File rootDirectory = new File(root);
        getFile(rootDirectory);
        ExecutorService service = Executors.newFixedThreadPool(4);
        for(final File f:findingFiles) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    if (getFileExtension(f) != -1) {
                        String s;
                        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                            while ((s = reader.readLine()) != null) {
                                if (s.contains(text)) {
                                    fCount++;
                                    result.add(f.getAbsolutePath());

                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            });

        }
        service.shutdown();
        try {
            service.awaitTermination(2, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf(String.format("%s %s %s%n","текст найден в",fCount,"файлах"));
    }

    /**
     * отображаем список
     * путей файлов,в которых найден текст
     */
    public void showPathList() {
        for (String path:result) {
            System.out.printf(String.format("%s%s \n",path,";"));
        }
    }


    /**
     * класс,работающий
     * в однопоточном режиме
     */

    class PSearch {

        public void textParseSingleThread() {
            String txt;
            File directory = new File(root);


            for (final File f : getFile(directory)) {
                if (!f.isFile() || getFileExtension(f) == -1) {
                    return;
                }

                try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                    while ((txt = reader.readLine()) != null) {
                        if (txt.contains(text)) {
                            singleThreadResult.add(f);
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}


/**
 * Класс оценки производительности
 * методов поиска в двух классах
 */
class ProcessCompare {
    /**
     * список поддерживаемых расширений
     */
    static  List<String> e = Arrays.asList(".txt",".doc",".xml");
    /**
     * конфигурационный файл
     */
    static Settings set = new Settings();
    /**
     * класс поиска текста в файлах
     * с использованием сервиса-исполнителя
     */
    private final ParallelSearching ps;
    /**
     *класс реализующий однопоточное
     * выполнение
     */
    private final ParallelSearching.PSearch p;
    /**
     * путь к директории
     */
    private final String root;
    /**
     * искомый тексст
     */
    private final String text;

    /**
     * конструктор принимающий
     * оба поиска текста
     * @param root - путь к файлу
     * @param text - искомый текст
     *
     */
    public ProcessCompare(final String root,
                          final String text
    ) {
        this.root = root;
        this.text = text;
        this.ps = new ParallelSearching(root,text,e);
        this.p  = new ParallelSearching(root,text,e).new PSearch();


    }


    /**
     * метод определяет
     * производительность
     * методов поиска текста
     * в однопоточном  и многопоточном
     * вариантах
     *
     * @return - разница во времени выполненния
     */
    public double timeCompare() {
        long startTime1 = System.nanoTime();
        ps.textParser();
        ps.showPathList();
        double endTime1 = ((double)System.nanoTime()
                - startTime1) / 1000000000;

        long startTime2 = System.nanoTime();
        p.textParseSingleThread();
        double endTime2 = ((double)System.nanoTime()
                - startTime2) / 1000000000;
        return endTime2 / endTime1;
    }

    public static void main(String[] args) {
        set.load();
        System.out.println(set.getValue("inputFile"));
        System.out.printf(String.format("%n%s%n%.2f %s \n",
                "Класс с пулом потоков в",
                new ProcessCompare(
                        set.getValue("inputFile"),
                        "low").timeCompare(),
                "раз быстрее выполняет задачу"));

    }
}