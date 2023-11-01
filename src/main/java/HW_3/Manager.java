package HW_3;

import java.time.LocalDate;
import java.util.List;

public class Manager extends Employee {
    public Manager(String name, String midName, String surName,
                    String phone, String position, int salary, LocalDate birthday) {
        super(name, midName, surName, phone, position, salary, birthday);
    }

    public static void increaseSalary(List <Employee> employees, int salaryIncreaseAmount) {
        for (Employee employee : employees) {
            if (!(employee instanceof Manager)) {
                employee.setSalary(employee.getSalary() + salaryIncreaseAmount);
            }
        }
    }


}
