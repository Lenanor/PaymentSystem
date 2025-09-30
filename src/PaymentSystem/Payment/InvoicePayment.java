package PaymentSystem.Payment;

public class InvoicePayment extends Payment {
    private String client;
    private String invoiceNumber;

    public InvoicePayment() {
        this.client = "Kalle Andersson";
        this.invoiceNumber = "F-111";
    }

    @Override
    public String processPayment(double amount) {
        // Build receipt
        Receipt receipt = new Receipt.Builder()
                .paymentMethod("INVOICE")
                .terms("Within 30 days")
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
