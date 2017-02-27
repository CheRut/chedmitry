package ru.chedmitriy.socket.fileManager.objects;

import ru.chedmitriy.chess.usage.ConsoleIO;
import ru.chedmitriy.socket.fileManager.model.ClientServerDialog;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by dimsan on 05.02.2017.
 */
public class Client extends ClientServerDialog {

    /**
     * .
     * Класс ввода/вывода
     */
    ConsoleIO cIO = new ConsoleIO();

    private final int port;
    private final String ip;
    private final Socket socket;


    /**
     * .
     * конструктор класса
     *
     * @param ip   - адрес сервера
     * @param port - номер открытого порта
     *             сервера
     */
    public Client(String ip, int port) throws IOException {
        super(ip, port);
        this.ip = ip;
        this.port = port;
        socket = new Socket(InetAddress.getByName(ip), port);
    }


    /**
     * .
     * Метод, используемы только для имитации
     * меню на стороне клиента.
     * Отображает возможные
     */
    public String menuList() {
        System.out.println("MENU: ");
        String[] menu = new String[]{"1.'download' - Введите имя файла для скачивания;",
                "2.'upload' - Введите имя файла для загрузки на сервер;",
                "3.'up' - Вверх по директории;",
                "4.'down' - Вниз по директории;",
                "5.'showC' - Содержимое директории на клиентской стороне;",
                "6.'showS' - Содержимое директории на стороне сервера;",
                "7.'exit' - Для выхода."};
        String menuItem = "";
        for (String choosingVar : menu) {
            menuItem = choosingVar;


            cIO.println(menuItem);
        }

        return menuItem;
    }

    /**
     * .
     * Метод, спомощью которого
     * клиент отправляет запросы
     * на сервер
     */
    public void clientRequest() throws IOException {

        try (PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
             InputStream is = socket.getInputStream();
             OutputStream os = socket.getOutputStream()) {
            String userPrint;

            do {
                menuList();
                userPrint = cIO.ask("Выберите действие");
                out.println(userPrint);
                recieveFileByClient(userPrint, in, is, out);
                transmitFileToServer(userPrint, os, out);
                upClientRootDirectory(userPrint);
                downClientDirectory(userPrint);
                showClient(userPrint, in, out);
            }

            while (!("exit".equals(userPrint)));
        }
    }

    public static void main(String[] args) throws IOException {
        new Client("localhost", 5000).clientRequest();
    }


}

