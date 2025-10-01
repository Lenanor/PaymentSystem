package PaymentSystem.shoppingCart;

import java.util.*;

// Order class
class Order {
    private static int nextOrderId = 1;

    private int orderId;
    private List<Item> items;
    private Date orderDate;

    public Order(List<Item> items) {
        this.orderId = nextOrderId++;
        this.items = new ArrayList<>(items);
        this.orderDate = new Date();
    }

    public int getOrderId() { return orderId; }
    public List<Item> getItems() { return items; }
    public Date getOrderDate() { return orderDate; }

    public void setItems(List<Item> newItems) {
        this.items = newItems;
    }

    @Override
    public String toString() {
        return "Order #" + orderId + " on " + orderDate + "\nItems: " + items;
    }
}