package PaymentSystem.shoppingCart;

import PaymentSystem.Catalog.ShoppingItem;
import java.util.ArrayList;
import java.util.List;

// ShoppingCart class
public class ShoppingCart {
    private List<ShoppingItem> cartItems = new ArrayList<>();

    public void addItem(ShoppingItem item) {
        cartItems.add(item);
    }

    public ShoppingItem removeItem(int id)
    {
        ShoppingItem removedItem = null;

        for (ShoppingItem item : cartItems)
        {
            if (item.getItemId() == id)
            {
                removedItem = item;
                cartItems.remove(item);
                break;
            }
        }

        return removedItem;
    }

    public double calculateTotal() {
        return cartItems.stream().mapToDouble(ShoppingItem::getPrice).sum();
    }

    public List<ShoppingItem> getItems() {
        return cartItems;
    }

    public void clearCart() {
        cartItems.clear();
    }
    public Order makeOrder() {
        if (cartItems.isEmpty()) {
            throw new IllegalStateException("Cannot create order from empty cart.");
        }

        Order order = new Order(cartItems);
        clearCart(); // optional: comment out if you want to retain items
        return order;
    }

    @Override
    public String toString() {
        return "Kundvagn: " + cartItems.toString();
    }
}