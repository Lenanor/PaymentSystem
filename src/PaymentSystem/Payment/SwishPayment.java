package PaymentSystem.Payment;

public class SwishPayment extends Payment {
    private String phoneNumber;

    public SwishPayment(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String processPayment(double amount) {
        System.out.println("Processing swish payment. Amount:" + amount);
        return super.processPayment(amount);
    }

    @Override
    public void refund(double amount) {
        super.refund(amount);
        System.out.println("Refunding swish payment. Amount:" + amount);
    }
}
