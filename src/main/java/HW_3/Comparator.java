package HW_3;

public class Comparator implements java.util.Comparator<Employee> {
    public int compare(Employee o1, Employee o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}
