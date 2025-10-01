package PaymentSystem.shoppingCart;
import PaymentSystem.Catalog.ShoppingItem;

import java.util.*;

class OrderManager {
    private Map<Integer, Order> orders = new HashMap<>();

    // Create
    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    // Read
    public Order getOrder(int orderId) {
        return orders.get(orderId);
    }

    // Update
    public void updateOrder(int orderId, List<ShoppingItem> updatedItems) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setItems(updatedItems);
        }
    }

    // Delete
    public void deleteOrder(int orderId) {
        orders.remove(orderId);
    }

    public void printAllOrders() {
        for (Order order : orders.values()) {
            System.out.println(order);
            System.out.println("-----");
        }
    }
}