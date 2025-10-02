package PaymentSystem.Payment;

public class InvoicePayment extends Payment {
    private String client;
    private String invoiceNumber;
    private String terms;

    private static int invoiceCounter = 111;

    public InvoicePayment(String fullName) {
        this.client = fullName;
        this.invoiceNumber = "F-" + invoiceCounter++;
        this.terms = "Within 30 days";
    }

    @Override
    public Receipt processPayment() {
        // Build receipt

        return new Receipt.Builder()
                .paymentMethod("INVOICE")
                .terms(this.terms)
                .invoiceNumber(this.invoiceNumber)
                .phoneNumber(this.client)
                .items(getShoppingItems())
                .total(getTotalSum())
                .discountSum(getDiscountSum())
                .formatter(new InvoiceFormatter())
                .build();
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding invoice payment. Amount:" + amount);
        super.refund(amount);
    }
}
