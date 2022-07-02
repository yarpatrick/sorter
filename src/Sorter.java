import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Sorter {
    public static void main(String[] args) {
        try {
            ArrayList list;
            var student = new Student();
            File fileRead = new File("Students.txt");
            File fileWrite = new File("SortStudents.txt");
            list = student.readInList(fileRead);
            var arrayStudents = new Student[list.size()];
            student.readInStudents(arrayStudents, list);
            var sort = new IntroSort(arrayStudents);
            sort.sortData();
            PrintWriter printWriter = new PrintWriter(fileWrite);
            student.print(sort.students, printWriter);
            printWriter.close();
        }
        catch (IOException e)
        {
            System.out.println("Error" + e);
        }
    }
}

