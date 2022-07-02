import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Comparator;

public class Sorter {
    public static void main(String[] args) {
        try {
            ArrayList list;
            var workers = new Worker();
            File fileRead = new File("File.txt");
            File fileWrite = new File("FileSort.txt");
            list = workers.readInList(fileRead);
            var arrayWorkers = new Worker[list.size()];
            workers.readInWorkers(arrayWorkers, list);
            var hairbrush = new HairbrushSort();
            hairbrush.Sort(arrayWorkers, new CompareWorker());
            PrintWriter printWriter = new PrintWriter(fileWrite);
            workers.print(arrayWorkers, printWriter);
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }
}

