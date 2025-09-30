package PaymentSystem;

import PaymentSystem.Payment.CardPayment;
import PaymentSystem.Payment.InvoicePayment;
import PaymentSystem.Payment.Payment;
import PaymentSystem.Payment.SwishPayment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cashier {
    private List<Payment> payments;
    private Map<String, Payment> processedPayments;

    public Cashier() {

        payments = new ArrayList<>();
        processedPayments = new HashMap<>();

        payments.add(new CardPayment("123456789", ""));
        payments.get(0).addItem(new ShoppingItem("Bullar", 35));
        payments.get(0).addItem(new ShoppingItem("Kakor", 25));
        payments.get(0).addItem(new ShoppingItem("Kaffe", 40));

        payments.add(new SwishPayment("123"));
        payments.add(new InvoicePayment("Viola Bengtsson"));

        for (Payment payment : payments){
            processedPayments.put(payment.processPayment(payment.getTotalSum()), payment);
        }

        payments.get(0).refund(50);
    }
}
