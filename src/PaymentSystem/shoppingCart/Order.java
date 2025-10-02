package PaymentSystem.shoppingCart;

import PaymentSystem.Catalog.ShoppingItem;

import java.util.*;

// Order class
public class Order {
    private static int nextOrderId = 1;

    private int orderId;
    private List<ShoppingItem> ShoppingItems;
    private Date orderDate;

    public Order(List<ShoppingItem> ShoppingItems) {
        this.orderId = nextOrderId++;
        this.ShoppingItems = new ArrayList<>(ShoppingItems);
        this.orderDate = new Date();
    }

    public int getOrderId() { return orderId; }
    public List<ShoppingItem> getItems() { return ShoppingItems; }
    public Date getOrderDate() { return orderDate; }

    public void setItems(List<ShoppingItem> newItems) {
        this.ShoppingItems = newItems;
    }

    @Override
    public String toString() {
        return "Order #" + orderId + " on " + orderDate + "\nItems: " + ShoppingItems;
    }
}