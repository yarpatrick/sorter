import java.util.Comparator;

class CompareWorker implements Comparator<Worker> {
    public int compare(Worker x, Worker y) {
        if (x.getWorkPrice() > y.getWorkPrice())
            return 1;
        else if (x.getWorkPrice() < y.getWorkPrice())
            return -1;
        else if (x.getWorkPrice() == y.getWorkPrice())
            return y.getSurname().compareTo(x.getSurname());
        return 0;
    }
}
