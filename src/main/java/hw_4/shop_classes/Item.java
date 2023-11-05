package hw_4.shop_classes;

public class Item {
    String name;
    int cost;


    public Item(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Item{name='" + name + "', cost=" + cost + "}";
    }
}
