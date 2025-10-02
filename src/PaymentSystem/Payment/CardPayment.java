package PaymentSystem.Payment;

public class CardPayment extends Payment{

    private String cardNumber;
    private String CVV;


    public CardPayment(String cardNumber, String CVV) {
        this.cardNumber = cardNumber;
        this.CVV = CVV;
    }


    @Override
    public Receipt processPayment() {
        return new Receipt.Builder()
                .paymentMethod("CARD")
                .receiptNumber(getReceiptNumber())
                .cardNumber(this.cardNumber)
                .items(getShoppingItems())
                .total(getTotalSum())
                .discountSum(getDiscountSum())
                .formatter(new CardReceiptFormatter())
                .build();
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding card payment. Amount left:" + getRemainingRefundable());
    }
}
