package ru.chedmitriy.socket.fileManager.model;

import org.apache.log4j.Logger;
import ru.chedmitriy.chess.usage.ConsoleIO;
import ru.chedmitriy.service.Settings;
import ru.chedmitriy.socket.fileManager.objects.Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Dmitry Cherutsa on 13.02.2017.
 * @version $Id$
 * @project junior
 * @since 0.1
 */
public abstract class ClientServerDialog implements SocketRequestModel, ServerAnswerModel {
    /**
     * размер файл при передаче/приеме
     */
    private final int SIZE = 64 * 1024; // 64 KB

    /**
     * .
     * для доступа к файлу конфигурации
     * ипользую класс Settings
     */
    Settings settings = new Settings();
    /**
     * .
     * объвление константы
     * для логгирования
     */
    private static final Logger log = Logger.getLogger(Client.class.getName());
    /**
     * .
     * Класс ввода/вывода
     */
    ConsoleIO cIO = new ConsoleIO();

    /**
     * .
     * читаем с клавиатуры
     */
    Scanner console = new Scanner(System.in);
    private int port;
    private String ip;
    private Socket socket;
    /**.
     * уазатель директории сервера
     * */
    private boolean serverHD = false;
    /**
     * указатель директории клиента
     * */
    private boolean clientHD = false;
    /**
     * .
     * Определяю корневую папку
     * на стороне клиента
     */
    File clientSideFile = new File("./");
    /**
     * .
     * Определяю корневую папку
     * на стороне сервера
     */
    File serverFilePath = new File("./");

    /**
     * .
     * Конструктор клиента
     */
    public ClientServerDialog(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
    }

    /**
     * .
     * Конструктор сервера
     */
    public ClientServerDialog(Socket socket) {
        this.socket = socket;
    }

    /**
     * .
     * Задаем вопрос клиенту и
     * читаем с клавиатуры
     *
     * @param s - строка в консоль
     * @return console - читаем с клавиатуры
     */
    public String ask(String s) {
        cIO.println(s);
        return console.nextLine();
    }

    /**
     * Читаем поток с сервера
     * Здесь список файлов
     * корневой директории
     * клиента
     * *
     *
     * @throws IOException - исключение
     *                     ввода/вывода
     */
    public void listOfFilesIn() throws IOException {
        cIO.println("Директория клиентскокой стороны: ");
        if (this.clientSideFile.exists()) {
            for (File f : this.clientSideFile.listFiles()) {
                cIO.println(" - " + f.getName());
            }
            cIO.println("конец списка:");
        } else if (this.clientSideFile == null) {

            for (File f : this.clientSideFile.listFiles()) {
                while (!f.getName().isEmpty()) {
                    cIO.println(" - " + f.getName());
                }
            }
            cIO.println("");
        } else {
            log.error("Директории(файла)" + this.clientSideFile.getName() + " не существует ");
        }

    }

    /**
     * .
     * Метод отправляет клиенту содержимое
     * директории сервера,
     * с которой работает программа
     *
     * @param file - файл,относительно которого
     *             выводится содержимое
     * @param out  - поток,передающий сообщение клиенту
     */
    public void listOfFilesOut(File file, PrintWriter out) {
        cIO.println("Содержимое рабочей директории сервера: ");
        if (file.exists()) {
            for (File f : file.listFiles()) {
                String fileName = f.getName();
                if (!fileName.isEmpty()) {
                    out.println(" - " + fileName);
                }
            }
        } else if (file == null) {
            file = this.serverFilePath;
            for (File f : file.listFiles()) {
                out.println(" - " + f.getName());
            }
        } else {
            log.error("Директории(файла)" + file.getName() + " не существует ");
        }
        out.println("Конец списка:");
        out.println("");

    }

    /**
     * .
     * Поднимаемся в родительский для файла каталог
     *
     * @param requestMessage - имя файла;
     */
    @Override
    public void upClientRootDirectory(String requestMessage) {
        if ("up".equals(requestMessage)) {
            log.info("Перемещаемся в родительский каталог");
            File file = this.clientSideFile.getAbsoluteFile().getParentFile();
            if (file.exists()) {
                for (File f : file.listFiles()) {
                    cIO.println("- " + f.getName());
                }
            } else {
                log.error("Директории(файла)" + this.clientSideFile.getName() + " не существует ");
            }
            cIO.println("");
        }
    }

    /**
     * .
     * Переходим в директорию
     *
     * @param requestMessage - имя файла;
     */
    @Override
    public void downClientDirectory(String requestMessage) {
        if ("down".equals(requestMessage)) {
            log.info("Движение по директории вниз:");
            String path;
            String absPath = "./";
            do {
                path = ask("Выберите папкку,содержимое которой Вас интересует: ");
                /**.
                 * Если введено слово "upClientRootDirectory" -
                 * двигаемся на верх - в родительскую директорию
                 * */
                if ("upClientRootDirectory".equals(path)) {
                    upClientRootDirectory(path);
                    this.clientSideFile = new File(this.clientSideFile.getParent());
                    return;
                }
                this.clientSideFile = new File(absPath + "\\" + path);
                System.out.println(this.clientSideFile.getAbsolutePath());
                log.info("Выбрана папка " + this.clientSideFile);
                if (clientSideFile.exists() && clientSideFile.isDirectory()) {
                    for (File f : clientSideFile.getAbsoluteFile().listFiles()) {
                        System.out.println(f.getName());
                    }
                } else {
                    log.error("Директории " + clientSideFile.getName() + " не существует ");
                }
                absPath = absPath + "\\" + this.clientSideFile;

            } while (!"ok".equals(path));
            this.clientSideFile = new File("./");
        }

    }

    /**
     * .
     * отображаем содержимое директории
     *
     * @param out            - запрос ;
     * @param in             - ответ;
     * @param requestMessage - ключ входа в метод
     * @throws IOException - исключение ввода/вывода
     */
    @Override
    public void showClient(String requestMessage, BufferedReader in, PrintWriter out) throws IOException {
        if ("showC".equals(requestMessage)) {
            listOfFilesIn();
            this.clientHD = true;
            this.serverHD = false;
        }
        if ("showS".equals(requestMessage)) {
            this.clientHD = false;
            this.serverHD = true;
            serverShow("showS", out);
            String readLines;
            do {
                readLines = in.readLine();
                System.out.println(readLines);
            } while (!"".equals(readLines));
        }
    }

    /**
     * Метод отображает директорию сервера
     *
     * @param requestMessage - ключ входа в метод
     * @param out            - вывод
     */
    @Override
    public void serverShow(String requestMessage, PrintWriter out) {
        if ("showS".equals(requestMessage)) {
            listOfFilesOut(this.serverFilePath, out);

        }
    }

    /**
     * .
     * Метод получает список родительского каталога
     * и передает этот список потоком
     *
     * @param fileName       - имя фала, который находжится
     *                       в диретории с которой мы работаем
     * @param out            - поток,передающий сообщение клиенту
     * @param requestMessage - принимаемый запрос
     */
    @Override
    public void upServerRootDirectory(String requestMessage, String fileName, PrintWriter out) {
        if ("up".equals(requestMessage)) {
            log.info("Перемещаемся в родительский каталог");
            File file = new File(fileName).getAbsoluteFile().getParentFile();
            if (file.exists()) {
                for (File f : file.listFiles()) {
                    out.println("- " + f.getName());
                }
            } else {
                log.error("Директории(файла)" + this.clientSideFile.getName() + " не существует ");
            }
            out.println("");
        }
        out.flush();
    }

    /**
     * .
     * Метод перехода в подкаталог:
     * выбираем файл(путем ввода его имени)
     * и получаем список (если это директория)
     * содержащихся файлов
     *
     * @param out            - поток,передающий сообщение клиенту
     * @param requestMessage - принимаемый запрос
     */
    @Override
    public void downServerDirectory(String requestMessage, PrintWriter out) {
        if ("down".equals(requestMessage) && this.serverHD) {
            String absServerPath = "./";
            String path;
            path = ask("Выберите папкку,содержимое которой Вас интересует: ");
            this.serverFilePath = new File(absServerPath + "\\" + path);
            log.info("Выбрана папка в директории сервера: "
                    + this.serverFilePath.getName());
            do {
                if (this.serverFilePath.exists() && this.serverFilePath.isDirectory()) {
                    listOfFilesOut(this.serverFilePath, out);
                } else {
                    log.error("Директории "
                            + this.serverFilePath.getName()
                            + " не существует ");
                }
                absServerPath = absServerPath + "\\"
                        + this.serverFilePath;
            } while (!"ok".equals(path));
            this.serverFilePath = new File("./");
        } else if ("downClientDirectory".equals(requestMessage) && this.clientHD) {
            downClientDirectory(requestMessage);
        }
    }
    /**
     * .
     * Метод отправляет запрос
     * на сервер,чтобы скачать
     * конкретный файл
     * клиенту
     *
     * @param requestMessage - имя файла;
     * @param br             - прием запросов-ключей от сервера
     * @param in             - поток принимающий побайтово
     *                       выбранный файл.
     * @param pw             - передача запросов -ключей серверу
     */
    @Override
    public void recieveFileByClient(String requestMessage, BufferedReader br, InputStream in, PrintWriter pw) throws IOException {
        if ("download".equals(requestMessage)) {
            String readLines;
            do {
                readLines = br.readLine();
                cIO.println(readLines);
            } while (!"".equals(readLines));
            readLines = ask("Введите название файла для скачивания ");
            pw.println(readLines);
            this.clientSideFile = new File(readLines);
            log.info("Выбран файл для скачивания: " + this.clientSideFile.getName());
            log.info("Принимаем файл " + this.clientSideFile.getName());
            try (OutputStream out = new FileOutputStream(configToDowloadUpload("download.path", this.clientSideFile))) {
                byte[] bytes = new byte[SIZE];
                in.read(bytes);
                out.write(bytes);
                log.info("Файл " + readLines + " загружен клиенту...");
            }
        }
    }

    /**
     * .
     * Метод recieveFileByClient d файле конфигурации
     * app.properties находит путь для скачивания
     * с одного компьютера в папке c:\\temp\\ создается
     * условная папка для загрузки эта папка
     * относится к
     * клиентскому жесткому диску.
     * Сначала создается файл с именем загружаемого файла,
     * на диске клиента
     * затем,посредством побайтовой передачи
     * в него копируются значения
     *
     * @param requestMessage - принимаемый запрос
     * @param out            - вывод по байтам
     * @param pw             - вывод ответа
     * @param br             - поток принимающей ответ с сервера
     */
    @Override
    public void transmitFileFromServer(String requestMessage, OutputStream out, BufferedReader br, PrintWriter pw) throws IOException {
        if ("download".equals(requestMessage)) {
            listOfFilesOut(this.serverFilePath, pw);
            String request = br.readLine();
            this.serverFilePath = new File(request);
            if (this.serverFilePath.exists()) {
                try (InputStream in = new FileInputStream(this.serverFilePath.getAbsolutePath())) {
                    byte[] fileByByte = new byte[(int) this.serverFilePath.length()];
                    log.info("Передаем файл: " + this.serverFilePath.getAbsolutePath());
                    in.read(fileByByte, 0, fileByByte.length);
                    out.write(fileByByte, 0, fileByByte.length);
                }
                log.info(this.serverFilePath.getName() + " " + "Был успешно сохранен на стороне клиента");
            } else {
                log.error("Директории(файла)" + this.serverFilePath.getName() + " не существует ");
            }
        }

    }

    /**
     * .
     * Метод загрузки файла на сервер
     * *
     *
     * @param requestMessage - имя файла;
     * @param out            - исходящий поток байтов;
     * @param pw             - вывод ответа
     */
    @Override
    public void transmitFileToServer(String requestMessage, OutputStream out, PrintWriter pw) throws IOException {
        if ("upload".equals(requestMessage)) {
            listOfFilesIn();
            String readLines;
            readLines = ask("Введите название файла для загрузки или downClientDirectory/upClientRootDirectory для перехода по директории:");
            this.clientSideFile = new File(readLines);
            if (this.clientSideFile.exists()) {
                pw.println(readLines);
                byte[] fileByByte = new byte[(int) this.clientSideFile.length()];
                log.info("передача файла " + this.clientSideFile.getName() + " с клиента");
                try (InputStream in = new FileInputStream(this.clientSideFile.getAbsolutePath())) {
                    in.read(fileByByte, 0, fileByByte.length);
                    out.write(fileByByte, 0, fileByByte.length);
                    log.info("Выбран файл для загрузки: " + this.clientSideFile.getName());
                }
                log.info("файл передан с клиента");
            } else {
                log.error("Ошибка выбора файла! " +
                        System.getProperty("line.separator") + " Файл - "
                        + this.clientSideFile.getName() + " не найден");
            }

        }
    }

    public File configToDowloadUpload(String configProperty, File file) throws IOException {
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("app.properties")) {
            this.settings.load(io);
        }
        String value = settings.getValue(configProperty);
        /**Указываем путь загрузки*/
        File distFile = new File(value);
        if (!distFile.exists()) {
            distFile.mkdirs();
            distFile.createNewFile();
        }
        distFile = new File(distFile.getAbsolutePath() + "\\" + file.getName());
        System.out.println(distFile.getAbsolutePath());
        return distFile;
    }

    /**
     * .
     * Метод transmitFileToServer файле конфигурации
     * app.properties находит путь для загрузки
     * с одного компьютера в папке c:\\temp\\ создается
     * условная папка для загрузки эта папка
     * относится к
     * серверному жесткому диску.
     * Сначала создается файл с именем загружаемого файла,
     * на диске сервера
     * затем,посредством побайтовой передачи
     * в него копируются значения
     *
     * @param requestMessage - принимаемый запрос
     * @param pw             - поток -ответ
     * @param br             -входящий поток-ключ
     * @param in             - входящий поток байтов
     */
    @Override
    public void recieveFileByServer(String requestMessage, BufferedReader br, InputStream in, PrintWriter pw) throws IOException {
        if ("upload".equals(requestMessage)) {
            this.serverFilePath = new File(br.readLine());
            log.info("Загружаем файл  на сервер");
            try (OutputStream out = new FileOutputStream(configToDowloadUpload("upload.path", this.serverFilePath))) {
                log.info("пернимаю файла " + this.clientSideFile.getName() + " с клиента");
                byte[] fileByBy = new byte[SIZE];
                in.read(fileByBy);
                out.write(fileByBy);
                log.info("Файл успешно загружен на сервер");
            }

        }
    }


}

