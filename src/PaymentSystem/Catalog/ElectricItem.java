package PaymentSystem.Catalog;

public class ElectricItem extends ShoppingItem
{
    private String energyClass;

    public ElectricItem(String name, double price, String energyClass)
    {
        super(name, price);
        this.energyClass = energyClass;
    }

    public String getEnergyClass()
    {
        return energyClass;
    }
}
