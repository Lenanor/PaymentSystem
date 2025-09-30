package PaymentSystem.Catalog;

public class FoodItem extends ShoppingItem
{
    private String expirationDate;

    public FoodItem(String name, double price, String expirationDate)
    {
        super(name, price);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate()
    {
        return expirationDate;
    }
}
