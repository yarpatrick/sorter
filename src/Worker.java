import java.io.*;
import java.util.ArrayList;

class Worker {
    private String surname;
    private int workPrice;

    public void setSurname(String surname) {
        if (surname.equals(""))
            throw new IllegalArgumentException("surname = null");
        this.surname = surname;
    }

    public int getWorkPrice() {
        return workPrice;
    }

    public void setWorkPrice(int workPrice) {
        if (workPrice < 0)
            throw new IllegalArgumentException("point < 0");
        this.workPrice = workPrice;
    }

    public ArrayList readInList(File readFile) {
        ArrayList list = new ArrayList();
        try {
            FileReader fr = new FileReader(readFile);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void readInWorkers(Worker[] workers, ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            workers[i] = new Worker();
            String[] element = list.get(i).toString().split(", ");
            workers[i].setSurname(element[0]);
            workers[i].setWorkPrice(Integer.parseInt(element[1]));
        }
    }

    public void print(Worker[] workers, PrintWriter printWriter) {
        for (int i = 0; i < workers.length; i++) {
            printWriter.println((i + 1) + ")familia i ima " +
                    ": " + workers[i].getSurname() +
                    ", zarplata " + workers[i].getWorkPrice());
        }
    }

    public String getSurname() {
        return surname;
    }
}
