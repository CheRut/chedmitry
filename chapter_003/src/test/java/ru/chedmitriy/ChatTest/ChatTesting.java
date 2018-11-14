package ru.chedmitriy.chattest;

import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.consolechat.Chat;
import ru.chedmitriy.service.Settings;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by dimsan on 04.02.2017.
 */
public class ChatTesting {
    Chat chat;
    @Before
    public void init() {
        chat = new Chat(new File("source.txt"));
    }
    @Test
    public void continueRoboChatTest() {
        assertTrue(chat.continueRoboChat("продолжить"));

    }
    @Test
    public void muteRoboChattingTest() {
        assertTrue(chat.muteRoboChatting("стоп"));

    }
    @Test
    public void stopChattingTest() {
        assertTrue(chat.stopChatting("закончить"));

    }
    @Test
    public void classLoaderTest() throws IOException {
        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream io = loader.getResourceAsStream("log4j.properties")) {
            settings.load(io);
        }
        String value = settings.getValue("log4j.appender.file.File");
        assertThat(value, is("c:\\temp\\appLog\\log_file.txt"));
    }
}
