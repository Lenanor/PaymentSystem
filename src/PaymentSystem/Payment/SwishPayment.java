package PaymentSystem.Payment;

import java.util.ArrayList;
import java.util.List;

public class SwishPayment extends Payment {
    private String phoneNumber;

    public SwishPayment(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String processPayment(double amount) {
        // Build receipt
        Receipt receipt = new Receipt.Builder()
                .paymentMethod("SWISH")
                .receiptNumber(getReceiptNumber())
                .phoneNumber(this.phoneNumber)
                .items(getShoppingItems())
                .total(getTotalSum())
                .formatter(new SwishReceiptFormatter())
                .build();

        System.out.println(receipt);

        System.out.println("Processing swish payment. Amount:" + amount);
        return super.processPayment(amount);
    }

    @Override
    public void refund(double amount) {
        super.refund(amount);
        System.out.println("Refunding swish payment. Amount:" + amount);
    }
}
