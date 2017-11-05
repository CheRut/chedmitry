package ru.chedmitriy.multithreading.threads.monitor.ex1106;







import java.io.*;
import java.util.ArrayList;
import java.util.List;
import ru.chedmitriy.multithreading.threads.service.Settings;
/**
 * junior
 *
 * @author CheDmitry
 * @version 1.0
 * @since 31.10.17
 */
public class ParallelSearching {

    private final String root;
    private final String text;
    private  List<String> exts;

    public ParallelSearching(final String root, final String text, final List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }

    public void searchText() {
        String s;
            File file = new File(this.root);
            LineNumberReader lnr = null;
            if (file.isDirectory()) {
                for (File f : file.listFiles()) {
                    try {
                        lnr = new LineNumberReader(new BufferedReader(new FileReader(f)));
                        while ((s = lnr.readLine()) != null) {
                            if (s.equals(this.text)) {
                                exts.add(file.getAbsolutePath());
                            }
                        }
                        lnr.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    public void showList() {
        for (String s:this.exts) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {

        List<String> exts = new ArrayList<>();

        Settings settings = new Settings();

        settings.load();

        ParallelSearching ps = new ParallelSearching(settings.getValue("inputFile"),"low",exts);

        ps.searchText();

        ps.showList();
    }
}