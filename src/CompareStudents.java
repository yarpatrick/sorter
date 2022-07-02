import java.util.Comparator;

class CompareStudents implements Comparator<Student> {
    public int compare(Student x, Student y) {
        if (x.getPrice() > y.getPrice())
            return 1;
        else if (x.getPrice() < y.getPrice())
            return -1;
        else if (x.getPrice() == y.getPrice())
            return 2;
        return 0;
    }
}
