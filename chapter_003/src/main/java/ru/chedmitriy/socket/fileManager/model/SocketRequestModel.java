package ru.chedmitriy.socket.filemanager.model;

import java.io.*;

/**
 * @author Dmitry Cherutsa on 12.02.2017.
 * @version $Id$
 * @project junior
 * @since 0.1
 */
public interface SocketRequestModel {
    /**
     * .
     * Поднимаемся в родительский для файла каталог
     *
     * @param requestMessage - имя файла;
     */
    void upClientRootDirectory(String requestMessage);

    /**
     * .
     * Переходим в директорию
     *
     * @param requestMessage - имя файла;
     */
    void downClientDirectory(String requestMessage);

    /**
     * .
     * отображаем содержимое директории
     *
     * @param in             -  входящий  поток
     *                       файлом на  сервере
     * @param requestMessage - ключ входа в метод
     * @param out            -исходящий поток ключ
     */
    void showClient(String requestMessage, BufferedReader in, PrintWriter out) throws IOException;


    /**
     * .
     * метод загрузки клиентом
     *
     * @param in             -  входящий байтовый поток
     * @param br             - входящий поток -ключ
     * @param pw             -исходящий поток ключ
     * @param requestMessage - ключ входа в метод
     */
    void recieveFileByClient(String requestMessage, BufferedReader br, InputStream in, PrintWriter pw) throws IOException;

    /**
     * .
     * метод загрузки на сервер
     *
     * @param out            -  исходящий байтовый поток     *
     * @param pw             -исходящий поток ключ
     * @param requestMessage - ключ входа в метод
     */
    void transmitFileToServer(String requestMessage, OutputStream out, PrintWriter pw) throws IOException;
}
