package PaymentSystem.Payment;

import java.util.ArrayList;
import java.util.List;

public class SwishPayment extends Payment {
    private String phoneNumber;

    public SwishPayment(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Receipt processPayment() {
        // Build receipt

        return new Receipt.Builder()
                .paymentMethod("SWISH")
                .receiptNumber(getReceiptNumber())
                .phoneNumber(this.phoneNumber)
                .items(getShoppingItems())
                .total(getTotalSum())
                .discountSum(getDiscountSum())
                .formatter(new SwishReceiptFormatter())
                .build();
    }

    @Override
    public void refund(double amount) {
        super.refund(amount);
        System.out.println("Refunding swish payment. Amount:" + amount);
    }
}
