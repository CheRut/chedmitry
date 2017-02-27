package ru.chedmitriy.socket.fileManager.objects;

import ru.chedmitriy.chess.usage.ConsoleIO;
import ru.chedmitriy.socket.fileManager.model.ClientServerDialog;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dimsan on 05.02.2017.
 */
public class Server extends ClientServerDialog {

    /**
     * .
     * Класс ввода/вывода
     */
    ConsoleIO cIO = new ConsoleIO();

    /**
     * .
     * Значение сокета-величина
     * неизменяемая
     */
    public final Socket socket;


    /**
     * .
     * Конструктор класса
     *
     * @param socket
     */
    public Server(Socket socket) {
        super(socket);
        this.socket = socket;
    }

    /**
     * .
     * Метод -запрос клиента:
     * принимает буфферизированный поток
     * выводит строку
     *
     * @param brIn - входящий поток
     * @return String
     */
    public String clientRequest(BufferedReader brIn) throws IOException {
        String clientSay = brIn.readLine();
        return clientSay;
    }

    /**
     * .
     * главный метод,позволяющий
     * получать и отправлять запросы
     * с сервера
     * Метод работает до тех пор пока
     * пользователь не введет
     * на стороне клиента "exit".
     * Сервер получает запросы клиента
     * и обрабатывает их посредством
     * оператора Switch
     * Что бы  процесс выполнения программы был
     * более наглядный,использую
     * вывод в консоль некоторх процессов
     *
     * @throws IOException - исключение ввода/вывода
     */
    public void start() throws IOException {
        try (PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
             InputStream iss = socket.getInputStream();
             OutputStream oss = socket.getOutputStream()) {
            String ask = null;
            do {
                cIO.println("Ожидаение запроса от клиента ... ");
                ask = clientRequest(in);
                transmitFileFromServer(ask, oss, in, out);
                recieveFileByServer(ask, in, iss, out);
                upServerRootDirectory(ask, clientRequest(in), out);
                downServerDirectory(ask, out);
                serverShow(ask, out);
            } while (!("exit".equals(ask)));
        }
    }

    public static void main(String[] args) throws IOException {
        try (final Socket socket = new ServerSocket(5000).accept()) {
            new Server(socket).start();
        }
    }

}
