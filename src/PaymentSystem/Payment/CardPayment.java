package PaymentSystem.Payment;

public class CardPayment extends Payment{

    private String cardNumber;
    private String CVV;


    public CardPayment(String cardNumber, String CVV) {
        this.cardNumber = cardNumber;
        this.CVV = CVV;
    }

    @Override
    public String processPayment(double amount) {
        System.out.println("Processing card payment. Amount:" + amount);
        return super.processPayment(amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding card payment. Amount left:" + getRemainingRefundable());
    }
}
