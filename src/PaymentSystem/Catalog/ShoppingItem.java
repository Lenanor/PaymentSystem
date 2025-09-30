package PaymentSystem.Catalog;

public class ShoppingItem
{
    private int itemId;
    private String name;
    private double price;

    public ShoppingItem(String name, double price)
    {
        this.itemId = -1;
        this.name = name;
        this.price = price;
    }

    public int getItemId()
    {
        return itemId;
    }

    public void setItemId(int itemId)
    {
        this.itemId = itemId;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    @Override
    public String toString()
    {
        return itemId +
                ". " + name +
                ", Price: " + price;
    }
}
