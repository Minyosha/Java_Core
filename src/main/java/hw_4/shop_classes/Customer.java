package hw_4.shop_classes;

public class Customer {
    String name;
    int age;
    String phone;

    public Customer(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + '\'' +
                ", age=" + age + ", phone='" + phone + "'}";
    }
}