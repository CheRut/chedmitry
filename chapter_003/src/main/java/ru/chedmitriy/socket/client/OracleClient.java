package ru.chedmitriy.socket.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by dimsan on 04.02.2017.
 */
public class OracleClient {
    private final int port;
    private final String ip;
    public OracleClient(String ip,int port){
        this.port = port;
        this.ip = ip;
    }

    public void clientRequest() throws IOException {

        Socket socket = new Socket(InetAddress.getByName(ip), port);
        System.out.println("подключаемся к серверу: "+ port);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner console = new Scanner(System.in);
        String userPrint = null;
        String streamRead = null;

    do {
        userPrint = console.nextLine();
        out.println(userPrint);

        if("exit".equals(userPrint)){
           while (!(streamRead = in.readLine()).isEmpty()){
               System.out.println(streamRead);
           }
        }

    } while (!("exit".equals(userPrint)));
    }

    public static void main(String[] args) throws IOException {
        OracleClient oracleClient = new OracleClient("localhost",5000);
        oracleClient.clientRequest();
    }
}
