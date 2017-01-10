package ru.chedmitriy.extSort;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by dimsan on 05.01.2017.
 */
public class SortingArray {
    public static void removeNthLine(String f, int toRemove) throws IOException {

    }
    public static void main(String[] args) throws IOException {

      ReadFile rf = new ReadFile();
        rf.fileSharing();

        int numbers[] = {1, 8, 16, 1024,31111};
        try
        {
            RandomAccessFile raf = new RandomAccessFile("int.txt","rw");
        String line;



            for (int i = 0; i<numbers.length; i++) {
                line = String.valueOf(numbers[i]);
                raf.write(line.getBytes());
                raf.write("\n".getBytes());
                if(line.equals("8")){
                raf.seek(raf.getFilePointer()-line.length()-1);
                    raf.write("".getBytes());
                }
                if(line.equals("16")){
                    raf.seek(raf.getFilePointer()-line.length()-1);
                    raf.write("".getBytes());
                }
            }
            System.out.println(raf.length());
            raf.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
//               public static void removeLine(RandomAccessFile raf,String line) throws IOException {
//                   String checkLine;
//                   long pointer;
//                   raf.seek(raf.getFilePointer()-(line.length()+1));
//                   System.out.println(raf.getFilePointer());
//
//                   try {
//                       char[]chars = line.toCharArray();
//                       for (int i = 0; i <chars.length ; i++) {
//                           chars[i] = '\0';
//                           raf.write(chars[i]);
//                       }
//
//                      raf.seek(raf.getFilePointer()+1);
//                       System.out.println(raf.getFilePointer());
////                           }
//                   } catch (IOException ex) {
//                       ex.printStackTrace();
//                   }
//
//               }



}

