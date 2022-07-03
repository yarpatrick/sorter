import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.time.*;
class Student extends Object{
    private String name, surname;
    private int date, month, year, price;
    LocalDate Year = LocalDate.now();
    public Student(String str){
        String[] element = str.split(",");
        setName(element[0]);
        setSurname(element[1]);
        setPrice(Integer.parseInt(element[5]));
        setYear(Integer.parseInt(element[4]));
        setMonth(Integer.parseInt(element[3]));
        setDate(Integer.parseInt(element[2]));
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
    public void setDate(int day) {
        if (day < 0 || day > 31) throw new IllegalArgumentException("���� ������� �������");
            if((month == 4 || month == 6 || month == 8 || month == 9 || month == 11) && day > 30)
            throw new IllegalArgumentException("���� ������� �������");
        if(month == 2 && year % 4 != 0 && day >= 29) throw new IllegalArgumentException("���� �� ������������� ������");
        if(month == 2 && year % 4 == 0 && day == 29) throw new IllegalArgumentException("���� �� ������������� ������");
        this.date = day;
    }
    public void setMonth(int month) {
        if (month < 0 || month > 12)
            throw new IllegalArgumentException("����� ������ �������");
        this.month = month;
    }
    public void setYear(int year) {
        if (year < 1922 || year > 2022)
            throw new IllegalArgumentException("��� ������ �������");
        this.year = year;
    }

    public void setPrice(int price) {
        if (price < 0)
            throw new IllegalArgumentException("��������� ������������");
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
