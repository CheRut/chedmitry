package ru.chedmitriy.socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dimsan on 04.02.2017.
 */
public class OracleServer {
    public final Socket socket;
    public OracleServer(Socket socket) {
        this.socket = socket;
    }

    public void serverStart() throws IOException {
            PrintWriter out
                    = new PrintWriter(this.socket.getOutputStream(), true);
            BufferedReader in
                    = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

                String ask = null;
                do {
                    System.out.println("wait command ...");
                    ask = in.readLine();
                    System.out.println(ask);
                    if ("Hello oracle".equals(ask)) {
                        out.println("Hello, dear friend, I'm a oracle.");
                        out.println();
                    } else if (!("exit").equals(ask)) {
                        out.println("I can't answer on your question");
                        out.println();
                    }
                } while (!("exit".equals(ask)));
    }

    public static void main(String[] args) throws IOException {
        try (final Socket socket = new ServerSocket(5000).accept()) {
        new OracleServer(socket).serverStart();
        }
    }
}
