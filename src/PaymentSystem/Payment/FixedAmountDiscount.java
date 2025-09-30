package PaymentSystem.Payment;

public class FixedAmountDiscount implements DiscountStrategy
{
    private final double amount;

    public FixedAmountDiscount(double amount)
    {
        this.amount = amount;
    }

    @Override
    public double applyDiscount(double price)
    {
        double newPrice = price - amount;
        return newPrice < 0 ? 0 : newPrice;
    }
}
