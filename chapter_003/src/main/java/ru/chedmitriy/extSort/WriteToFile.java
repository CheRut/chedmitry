package ru.chedmitriy.extSort;

import ru.chedmitriy.service.Settings;

import java.io.*;
import java.net.URL;


/**
 * @author Dmitry Cherutsa on 05.01.2017.
 * @version $Id$
 * @project junior
 * @since 0.1
 */
public class WriteToFile {
    public void fileOpen() throws FileNotFoundException {
String line;
        Settings settings = new Settings();
        URL url = getClass().getResource("/source.txt");
        File file = new File(url.getPath());
        System.out.println(file.getAbsolutePath());
        try {

            RandomAccessFile  source = new RandomAccessFile(file,"rw");
            while((line=source.readLine())!=null){
                System.out.println(line);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    public static void main(String[] args) {
        WriteToFile wf = new WriteToFile();

        try {
            wf.fileOpen();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}