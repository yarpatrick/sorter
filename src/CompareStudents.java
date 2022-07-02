import java.util.Comparator;

class CompareStudents implements Comparator<Student> {
    public int compare(Student x, Student y) {
        if (x.getPrice() > y.getPrice())
            return 1;
        else if (x.getPrice() < y.getPrice())
            return -1;
        else if (x.getPrice() == y.getPrice())
            return y.getName().compareTo(x.getName()) + y.getSurname().compareTo(x.getSurname());
        return 0;
    }
}
