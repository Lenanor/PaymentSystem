package PaymentSystem.Payment;

public class InvoicePayment extends Payment {

    @Override
    public String processPayment(double amount) {
        System.out.println("Processing invoice payment. Amount:" + amount);
        return generateReceiptNumber();
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding invoice payment. Amount:" + amount);
    }
}
