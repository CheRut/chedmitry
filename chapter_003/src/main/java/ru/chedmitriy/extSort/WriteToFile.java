package ru.chedmitriy.extSort;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * @author Dmitry Cherutsa on 05.01.2017.
 * @version $Id$
 * @project junior
 * @since 0.1
 */
public class WriteToFile {
    public static void main(String[] args) {
        RandomAccessFile file;
        Scanner sc = new Scanner(System.in);

        String name,surname;
        int age;
        System.out.println("Please input name");
        name = sc.next().toLowerCase();


        System.out.println("Please input surname");
        surname = sc.next().toLowerCase();

        System.out.println("Please input age");
        age = sc.nextInt();

        try{
            file = new RandomAccessFile(new File("chapter_003/src/main/resources/source.txt"),"rw");

            file.writeUTF(name);
            for (int i = 0; i < 20-name.length(); i++) {
                file.writeByte(20);
            }
            file.writeUTF(surname);
            for (int i = 0; i < 20-surname.length(); i++) {
                file.writeByte(20);
            }
            file.writeInt(age);

            file.close();
        }catch(IOException e){
            e.getStackTrace();
        }

    }
}
