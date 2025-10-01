package PaymentSystem.shoppingCart;

import java.util.ArrayList;
import java.util.List;

// ShoppingCart class
class ShoppingCart {
    private List<Item> cartItems = new ArrayList<>();

    public void addItem(Item item) {
        cartItems.add(item);
    }

    public void removeItem(Item item) {
        cartItems.remove(item);
    }

    public double calculateTotal() {
        return cartItems.stream().mapToDouble(Item::getPrice).sum();
    }

    public List<Item> getItems() {
        return cartItems;
    }

    public void clearCart() {
        cartItems.clear();
    }

    @Override
    public String toString() {
        return "Cart: " + cartItems.toString();
    }
}