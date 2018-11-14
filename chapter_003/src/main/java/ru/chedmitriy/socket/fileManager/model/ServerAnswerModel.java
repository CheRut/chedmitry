package ru.chedmitriy.socket.filemanager.model;

import java.io.*;

/**
 * Created by dimsan on 14.02.2017.
 */
public interface ServerAnswerModel {
    /**
     * .
     * отображаем содержимое директории
     *
     * @param requestMessage - ключ входа в метод
     * @param out            -исходящий поток ключ
     */
    void serverShow(String requestMessage, PrintWriter out);

    /**
     * .
     * Переходим в директорию
     *
     * @param requestMessage - имя файла;
     * @param out            -исходящий поток ключ
     */
    void downServerDirectory(String requestMessage, PrintWriter out);

    /**
     * .
     * Поднимаемся в родительский для файла каталог
     *
     * @param requestMessage - имя файла;
     * @param fileName       - имя файла относительно
     *                       которого находим родителя
     * @param out            -исходящий поток ключ
     */
    void upServerRootDirectory(String requestMessage, String fileName, PrintWriter out);

    /**
     * .
     * метод загрузки клиентом
     *
     * @param out            -  исходящий байтовый поток
     * @param br             - входящий поток -ключ
     * @param pw             -исходящий поток ключ
     * @param requestMessage - ключ входа в метод
     */
    void transmitFileFromServer(String requestMessage, OutputStream out,
                                BufferedReader br, PrintWriter pw) throws IOException;
    /**
     * .
     * метод загрузки на сервер
     *
     * @param in             -  входящий байтовый поток     *
     * @param pw             -исходящий поток ключ
     * @param requestMessage - ключ входа в метод
     */
    void recieveFileByServer(String requestMessage, BufferedReader br,
                             InputStream in, PrintWriter pw) throws IOException;
}
