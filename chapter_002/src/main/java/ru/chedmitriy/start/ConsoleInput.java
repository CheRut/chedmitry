package ru.chedmitriy.start;



import java.util.Scanner;

/**
 * Created by dimsan on 18.09.2016.
 */
public class ConsoleInput implements InputStrValue,InputIntValue,Output {
    private Scanner scanner = new Scanner(System.in);


    public String ask(String question) {
        System.out.println((char)27 + "[33m"+question+": "+(char)27+"[0m");
        return scanner.next();
    }

    public int chooseOption(String question) {
        System.out.print((char)27 + "[33m"+question+": "+(char)27+"[0m");
        return scanner.nextInt();
    }

    public void outPrintln(Object obj) {
        System.out.println(obj);
    }

    public void outPrint(Object obj) {
        System.out.print(obj);
    }
}
