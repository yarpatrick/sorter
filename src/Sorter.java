import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Sorter {
    public static void main(String[] args) {
        try {
            ArrayList<String> list;
            var student = new Student();
            File fileRead = new File("Students.txt");
            File fileWrite = new File("SortStudents.txt");
            list = readInList(fileRead);
            var arrayStudents = new Student[list.size()];
            readInStudents(arrayStudents, list);
            var sort = new IntroSort(arrayStudents);
            sort.sortData();
            PrintWriter printWriter = new PrintWriter(fileWrite);
            student.print(sort.students, printWriter);
            printWriter.close();
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e);
        }
    }
    public static void readInStudents(Student[] students, ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            students[i] = new Student();
            String[] element = list.get(i).toString().split(",");
            students[i].setName(element[0]);
            students[i].setSurname(element[1]);
            students[i].setPrice(Integer.parseInt(element[5]));
            students[i].setYear(Integer.parseInt(element[4]));
            students[i].setMonth(Integer.parseInt(element[3]));
            students[i].setDate(Integer.parseInt(element[2]));
        }
    }
    public static ArrayList readInList(File readFile) {
        ArrayList list = new ArrayList();
        try {
            FileReader fileReader = new FileReader(readFile, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

