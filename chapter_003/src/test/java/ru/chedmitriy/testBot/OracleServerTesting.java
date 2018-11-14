package ru.chedmitriy.testbot;

import com.google.common.base.Joiner;
import org.junit.Test;
import ru.chedmitriy.socket.server.OracleServer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by dimsan on 05.02.2017.
 */
public class OracleServerTesting {
    private static final String LN = System.getProperty("line.separator");

    private void oracleTest(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);

        OracleServer server = new OracleServer(socket);
        server.serverStart();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenClientSayHello() throws IOException {
        this.oracleTest(
                Joiner.on(LN).join(
                        "Hello oracle",
                        "exit"
                ),
                String.format("Hello, dear friend, I'm a oracle.%s%s", LN, LN)
        );
    }

    @Test
    public void whenClientSayExit() throws IOException {
        this.oracleTest("exit", "");

    }

    @Test
    public void whenClientSaySomethingElse() throws IOException {
        this.oracleTest(
                Joiner.on(LN).join(
                        "unsupported ask",
                        "exit"
                ),
                Joiner.on(LN).join("I can't answer on your question", "", "")
        );
    }
}