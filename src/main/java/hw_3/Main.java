package hw_3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    //create some employees
    public static void main(String[] args) {
        Employee employee1 = new Employee("Ivan", "Ivanov", "Ivanov", "123456789", "Programmer", 1000, LocalDate.of(2010, 1, 21));
        Employee employee2 = new Employee("Petr", "Petrov", "Petrov", "123456789", "Programmer", 1000, LocalDate.of(2009, 3, 3));
        Employee employee3 = new Employee("Sergey", "Sergeev", "Sergeev", "123456789", "Programmer", 1000, LocalDate.of(2007, 5, 24));
        Employee employee4 = new Employee("Vladimir", "Vladimirov", "Vladimirov", "123456789", "Programmer", 1000, LocalDate.of(1997, 8, 9));
        Employee manager1 = new Manager("Ivan", "Ivanov", "Ivanov", "123456789", "Programmer", 1000, LocalDate.of(1996, 10, 12));

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(manager1);


        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Manager.increaseSalary(employees, 100);


        System.out.println("После увеличения зп:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("После сортировки по дате рождения:");
        Comparator comparator = new Comparator();
        Collections.sort(employees, comparator);
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }


}
