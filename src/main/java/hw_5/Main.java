package hw_5;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("John", new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0)), "Информатика");
        Student student2 = new Student("Jane", new ArrayList<>(Arrays.asList(2.0, 4.0, 5.0, 5.0, 5.0)), "Математика");
        Student student3 = new Student("Mark", new ArrayList<>(Arrays.asList(1.0, 1.0, 4.0, 4.0, 5.0)), "Физика");
        Student student4 = new Student("Emily", new ArrayList<>(Arrays.asList(2.0, 3.0, 2.0, 2.0, 2.0)), "Химия");
        Student student5 = new Student("David", new ArrayList<>(Arrays.asList(2.0, 4.0, 5.0, 2.0, 5.0)), "Биология");
        Student student6 = new Student("Sarah", new ArrayList<>(Arrays.asList(2.0, 2.0, 2.0, 3.0, 4.0)), "География");
        Student student7 = new Student("Виктор", new ArrayList<>(Arrays.asList(2.0, 3.0, 4.0, 4.0, 5.0)), "Информатика");
        Student student8 = new Student("Иван", new ArrayList<>(Arrays.asList(5.0, 4.0, 1.0, 1.0, 2.0)), "Информатика");
        Student student9 = new Student("Константин", new ArrayList<>(Arrays.asList(2.0, 2.0, 3.0, 4.0, 2.0)), "Информатика");
        Student student10 = new Student("Петр", new ArrayList<>(Arrays.asList(1.0, 2.0, 5.0, 5.0, 5.0)), "Информатика");
        Student student11 = new Student("Михаил", new ArrayList<>(Arrays.asList(3.0, 2.0, 5.0, 4.0, 1.0)), "Информатика");
        Student student12 = new Student("Биба", new ArrayList<>(Arrays.asList(5.0, 5.0, 5.0, 5.0, 5.0)), "Информатика");
        Student student13 = new Student("Боба", new ArrayList<>(Arrays.asList(5.0, 5.0, 5.0, 5.0, 5.0)), "Информатика");
        Student student14 = new Student("Гуня", new ArrayList<>(Arrays.asList(5.0, 5.0, 5.0, 5.0, 5.0)), "Информатика");
        Student student15 = new Student("Поцик", new ArrayList<>(Arrays.asList(1.0, 2.0, 1.0, 2.0, 4.0)), "Информатика");

        List <Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);
        students.add(student9);
        students.add(student10);
        students.add(student11);
        students.add(student12);
        students.add(student13);
        students.add(student14);
        students.add(student15);

        List<Student> studentsWithSpeciality = students.stream()
                .filter(student -> student.getSpeciality().equals("Информатика"))
                .sorted(Comparator.comparingDouble(Student::getAverageGrades).reversed())
                .toList();
        System.out.println("Список студентов специальности информатика, отсортированных в порядке убывания по среднему баллу:");
        studentsWithSpeciality.forEach(Student::printStudentWithAverage);
    }

}
