import java.io.*;
import java.util.ArrayList;

class Student extends Object{
    private String name, surname;
    private int date, month, year, price;

    public ArrayList readInList(File readFile) {
        ArrayList list = new ArrayList();
        try {
            FileReader fileReader = new FileReader(readFile);
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
    public void readInStudents(Student[] students, ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            students[i] = new Student();
            String[] element = list.get(i).toString().split(",");
            students[i].setName(element[0]);
            students[i].setSurname(element[1]);
            students[i].setDate(Integer.parseInt(element[2]));
            students[i].setMonth(Integer.parseInt(element[3]));
            students[i].setYear(Integer.parseInt(element[4]));
            students[i].setPrice(Integer.parseInt(element[5]));
        }
    }

    public void print(Student[] students, PrintWriter print) {
        for (int i = 0; i < students.length; i++) {
            print.println((i + 1) + " ‘амили€ и им€ студента : " +
                    students[i].getSurname() + students[i].getName() +
                    ". дата рождени€ : " +
                    students[i].getDate() + " " + students[i].getMonth() + " " + students[i].getYear() +
                    ". стипенди€ : " +
                    students[i].getPrice() +
                    "hashCode : " +
                    students[i].hashCode());
        }
    }
    public void setName(String name) {
        if (name.equals(""))
            throw new IllegalArgumentException("name = null");
        this.name = name;
    }
    public void setSurname(String surname) {
        if (surname.equals(""))
            throw new IllegalArgumentException("name = null");
        this.surname = surname;
    }
    public void setDate(int date) {
        if (date < 0 || date > 31)
            throw new IllegalArgumentException("name = null");
        this.date = date;
    }
    public void setMonth(int month) {
        if (month < 0 || month > 12)
            throw new IllegalArgumentException("name = null");
        this.month = month;
    }
    public void setYear(int year) {
        if (year < 1922 || year > 2022)
            throw new IllegalArgumentException("name = null");
        this.year = year;
    }

    public void setPrice(int price) {
        if (price < 0)
            throw new IllegalArgumentException("point < 0");
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int hashCode() {
        return this.surname.hashCode() + String.valueOf(this.price).hashCode();
    }

    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (obj instanceof Student) return false;
        return this.surname.equals(((Student) obj).surname) &&
                this.price ==(((Student) obj).price);
    }
}
