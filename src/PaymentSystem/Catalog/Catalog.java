package PaymentSystem.Catalog;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Catalog
{
    private static int idCounter = 0;
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

        item.setItemId(++idCounter);
        items.put(idCounter, item);
        stock.put(idCounter, amount);
        return true;
    }

    public boolean orderShoppingItem(int itemId, int amount)
    {
        if (stock.get(itemId) == null)
        {
            return false;
        }

        int newStock = stock.get(itemId) - amount;

        if (newStock < 0)
        {
            return false;
        }

        stock.put(itemId, newStock);
        return true;
    }

    public void printCatalog()
    {
        for (ShoppingItem item : items.values())
        {
            System.out.print(item);

            if (item instanceof FoodItem foodItem)
            {
                System.out.print(", (Food Expiration date " + foodItem.getExpirationDate() + ")");
            }
            else if (item instanceof ElectricItem electricItem)
            {
                System.out.print(", (Electric Energy Class " + electricItem.getEnergyClass() + ")");
            }
            else if (item instanceof ClothingItem clothingItem)
            {
                System.out.print(", (Clothing Size " + clothingItem.getSize() + ")");
            }

            System.out.println(", Stock: " + stock.get(item.getItemId()));
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
