import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.time.*;
class Student extends Object{
    private String name, surname;
    private int date, month, year, price, yearOld;
    LocalDate Year = LocalDate.now();
    public void print(Student[] students, PrintWriter print) {
        for (int i = 0; i < students.length; i++) {
            print.println((i + 1) + " Фамилия и имя студента : " +
                    students[i].getSurname() + " " + students[i].getName() +
                    ". Дата рождения : " +
                    students[i].getDate() + " " + students[i].getMonth() + " " + students[i].getYear() +
                    ". Возраст : " + students[i].birthdate() +
                    ". Стипендия : " +
                    students[i].getPrice() +
                    ". HashCode : " +
                    students[i].hashCode());
        }
    }
    public int birthdate(){
        return Math.abs(Period.between(Year, LocalDate.of(year,month,date)).getYears());
    }
    public void setName(String name) {
        if (name.equals(""))
            throw new IllegalArgumentException("Argument cannot be empty");
        this.name = name;
    }
    public void setSurname(String surname) {
        if (surname.equals(""))
            throw new IllegalArgumentException("Argument cannot be empty");
        this.surname = surname;
    }
    public void setDate(int date) {
        if (date < 0 || date > 31)
            if(month == 1|| month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            throw new IllegalArgumentException("дата введена неверно");
        if(month == 2 && year % 4 != 0 && date >= 29) throw new IllegalArgumentException("дата не соответствует месяцу");
        if(month == 2 && year % 4 == 0 && date < 29) throw new IllegalArgumentException("дата не соответствует месяцу");
        this.date = date;
    }
    public void setMonth(int month) {
        if (month < 0 || month > 12)
            throw new IllegalArgumentException("месяц введен неверно");
        this.month = month;
    }
    public void setYear(int year) {
        if (year < 1922 || year > 2022)
            throw new IllegalArgumentException("год введен неверно");
        this.year = year;
    }

    public void setPrice(int price) {
        if (price < 0)
            throw new IllegalArgumentException("стипендия отрицательна");
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
