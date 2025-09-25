package PaymentSystem;

public class ShoppingItem {

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ShoppingItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
