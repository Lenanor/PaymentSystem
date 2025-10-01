package PaymentSystem.Catalog;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Catalog
{
    private int idCounter = 0;
    private Map<Integer, ShoppingItem> items;
    private Map<Integer, Integer> stock;

    public Catalog()
    {
        this.items = new TreeMap<>();
        this.stock = new HashMap<>();
        addTestData();
    }

    public boolean addShoppingItem(ShoppingItem item, int amount)
    {
        if (amount < 0)
        {
            return false;
        }

        int id = item.getItemId();

        if (id == -1)
        {
            id = ++idCounter;
            item.setItemId(id);
        }

        if (stock.get(id) != null)
        {
            amount += stock.get(id);
        }

        items.put(id, item);
        stock.put(id, amount);
        return true;
    }

    public ShoppingItem orderShoppingItem(int itemId, int amount)
    {
        ShoppingItem shoppingItem = items.get(itemId);

        if (shoppingItem == null)
        {
            return null;
        }

        int newStock = stock.get(itemId) - amount;

        if (newStock < 0)
        {
            return null;
        }

        stock.put(itemId, newStock);
        return shoppingItem;
    }

    public void printCatalog()
    {
        for (ShoppingItem item : items.values())
        {
            System.out.print(item);

            if (item instanceof FoodItem foodItem)
            {
                System.out.print(", (Mat utgångsdatum " + foodItem.getExpirationDate() + ")");
            }
            else if (item instanceof ElectricItem electricItem)
            {
                System.out.print(", (Elektronik energiklass " + electricItem.getEnergyClass() + ")");
            }
            else if (item instanceof ClothingItem clothingItem)
            {
                System.out.print(", (Kläder storlek " + clothingItem.getSize() + ")");
            }

            System.out.println(", Antal: " + stock.get(item.getItemId()));
        }

        System.out.println();
    }

    private void addTestData()
    {
        addShoppingItem(new FoodItem("Bullar", 35, "2025-10-07"), 100);
        addShoppingItem(new FoodItem("Kakor", 25, "2025-11-15"), 200);
        addShoppingItem(new FoodItem("Kaffe", 40, "2026-02-01"), 300);
        addShoppingItem(new ElectricItem("Diskmaskin", 5000, "E"), 10);
        addShoppingItem(new ElectricItem("Kyl", 7000, "F"), 20);
        addShoppingItem(new ElectricItem("Frys", 6000, "D"), 5);
        addShoppingItem(new ClothingItem("Tröja", 550, "XL"),7);
        addShoppingItem(new ClothingItem("Byxor", 800, "L"),3);
        addShoppingItem(new ClothingItem("Skor", 1200, "46"),6);
    }
}
