import java.util.Comparator;

class CompareStudents implements Comparator<Student> {
    public int compare(Student x, Student y) {
        if (x.getStipend() > y.getStipend())
            return 1;
        else if (x.getStipend() < y.getStipend())
            return -1;
        else if (x.getStipend() == y.getStipend())
            return 2;
        return 0;
    }
}
