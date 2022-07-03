import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.StandardCharsets;
public class Utils {
    public static Student[] ConvertStudents(List<String> studentsAsString) {
        var arrayStudents = new Student[studentsAsString.size()];
        for (int i = 0; i < studentsAsString.size(); i++) {
            arrayStudents[i] = new Student(studentsAsString.get(i));
        }
        return arrayStudents;
    }

    public static void saveStudents(Student[] students, String fname) {
        try(PrintWriter printWriter = new PrintWriter(fname)) {
            for (int i = 0; i < students.length; i++) {
                printWriter.println((i + 1) + " Фамилия и имя студента : " +
                        students[i].getSurname() + " " + students[i].getName() +
                        ". Дата рождения : " +
                        students[i].getDate() + " " + students[i].getMonth() + " " + students[i].getYear() +
                        ". Возраст : " + students[i].birthdate() +
                        ". Стипендия : " +
                        students[i].getStipend() +
                        ". HashCode : " +
                        students[i].hashCode());
            }
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<String> readFromFile(String fname){
        File readFile = new File(fname);
        ArrayList<String> students = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(readFile, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                students.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
