package PaymentSystem.Catalog;

public class ClothingItem extends ShoppingItem
{
    private String size;

    public ClothingItem(String name, double price, String size)
    {
        super(name, price);
        this.size = size;
    }

    public String getSize()
    {
        return size;
    }
}
