package HW_3;

import java.time.LocalDate;

public class Employee {
    private static final int CURRENT_YEAR = 2023;
    String name;
    String midName;
    String surName;
    String position;
    String phone;
    int salary;
    LocalDate birthday;

    public Employee(String name, String midName, String surName, String phone, String position, int salary, LocalDate birthday) {
        this.name = name;
        this.midName = midName;
        this.surName = surName;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getMidName() {
        return midName;
    }

    public String getSurName() {
        return surName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", midName='" + midName + '\'' +
                ", surName='" + surName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }
}