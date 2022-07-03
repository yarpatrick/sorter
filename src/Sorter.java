import java.util.ArrayList;
public class Sorter {
    public static void main(String[] args) {
            ArrayList<String> studentData = Utils.readFromFile("Students.txt");
            Student[] studentGroup = Utils.ConvertStudents(studentData);
            var sort = new IntroSort(studentGroup);
            sort.sortData();
            Utils.saveStudents(sort.students, "SortStudents.txt");
        }
}

