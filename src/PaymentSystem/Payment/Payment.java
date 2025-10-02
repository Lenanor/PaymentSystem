package PaymentSystem.Payment;

import PaymentSystem.Refundable;
import PaymentSystem.Catalog.ShoppingItem;
import PaymentSystem.shoppingCart.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Payment implements Refundable {

    private String receiptNumber;
    private Order order;
    private double amountPaid;
    private double remainingRefundable;
    private DiscountStrategy discount;
    private double discountSum;

    public DiscountStrategy getDiscount() {
        return discount;
    }

    public double getDiscountSum() {
        return discountSum;
    }

    public void setDiscount(DiscountStrategy discount) {
        this.discount = discount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Payment() {
        this.receiptNumber = UUID.randomUUID().toString();
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


    public double getTotalSum(){
        double totalSum = 0;

        if (order == null){
            return 0;
        }

        for (ShoppingItem  shoppingItem : order.getItems()){
            totalSum += shoppingItem.getPrice();
        }

        if (discount != null){
            double sum = totalSum;
            totalSum = discount.applyDiscount(totalSum);
            this.discountSum = sum - totalSum;
        }
        return totalSum;
    }

    public List<ShoppingItem> getShoppingItems() {
        return order.getItems();
    }

    public double getAmountPaid(){
        return amountPaid;
    }

    public abstract Receipt processPayment();

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
