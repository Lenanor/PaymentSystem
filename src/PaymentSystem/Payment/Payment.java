package PaymentSystem.Payment;

import PaymentSystem.Refundable;
import PaymentSystem.ShoppingItem;

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

    public double getAmountPaid(){
        return amountPaid;
    }

    public String processPayment(double amount) {
        setAmountPaid(getAmountPaid() + amount);
        return generateReceiptNumber();
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
