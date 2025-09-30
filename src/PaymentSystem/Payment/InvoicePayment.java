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
    public String processPayment(double amount) {
        // Build receipt
        Receipt receipt = new Receipt.Builder()
                .paymentMethod("INVOICE")
                .terms(this.terms)
                .invoiceNumber(this.invoiceNumber)
                .phoneNumber(this.client)
                .items(getShoppingItems())
                .total(getTotalSum())
                .formatter(new InvoiceFormatter())
                .build();

        System.out.println(receipt);

        System.out.println("Processing invoice payment. Amount:" + amount);
        return super.processPayment(amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding invoice payment. Amount:" + amount);
        super.refund(amount);
    }
}
