package hw_5;

import java.util.List;

public class Student {
    private String name;
    private List<Double> grades;
    private String speciality;

    public Student(String name, List<Double> grades, String speciality) {
        this.name = name;
        this.grades = grades;
        this.speciality = speciality;
    }

    public String printStudent() {
        return this.name + " " + this.grades + " " + this.speciality;
    }

    public List<Double> getGrades() {
        return this.grades;
    }

    public double getAverageGrades() {
        return this.grades.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }
    public String getSpeciality() {
        return this.speciality;
    }

    public void printStudentWithAverage() {
        System.out.print(this.name + " " + this.grades + " " + this.speciality);
        System.out.print(" - ");
        System.out.println("Средний балл: " + this.getAverageGrades());
    }
}

