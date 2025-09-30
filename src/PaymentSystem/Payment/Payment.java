package PaymentSystem.Payment;

import PaymentSystem.Refundable;
import PaymentSystem.Catalog.ShoppingItem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Payment implements Refundable {

    private String receiptNumber;
    private final List<ShoppingItem> shoppingItems;
    private double amountPaid;
    private double remainingRefundable;

    public Payment() {
        this.shoppingItems = new ArrayList<>();
        this.receiptNumber = UUID.randomUUID().toString();

        shoppingItems.add(new ShoppingItem("Milk", 12.5));
        shoppingItems.add(new ShoppingItem("Bread", 3225.0));
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getRemainingRefundable() {
        return remainingRefundable;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void addItem(ShoppingItem item){
        shoppingItems.add(item);
    }

    public double getTotalSum(){
        double totalSum = 0;
        for (ShoppingItem shoppingItem : shoppingItems){
            totalSum += shoppingItem.getPrice();
        }

        return totalSum;
    }

    public List<ShoppingItem> getShoppingItems() {
        return shoppingItems;
    }

    public double getAmountPaid(){
        return amountPaid;
    }

    public String processPayment(double amount) {
        setAmountPaid(getAmountPaid() + amount);
        //receiptNumber = UUID.randomUUID().toString();
        return receiptNumber;
    }

    protected String generateReceiptNumber(){
        receiptNumber = UUID.randomUUID().toString();
        return receiptNumber;
    }

    @Override
    public void refund(double amount) {
        if (getAmountPaid() - amount > 0){
            remainingRefundable = getAmountPaid() - amount;
        }
        else {
            System.out.println("Refund is larger than amount paid");
        }
    }
}
