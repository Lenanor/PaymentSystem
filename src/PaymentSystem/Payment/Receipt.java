package PaymentSystem.Payment;

import PaymentSystem.Catalog.ShoppingItem;

import java.util.List;

public class Receipt {
    private String paymentMethod;
    private String receiptNumber; // Card, Swish
    private String cardNumber; // Card
    private String phoneNumber; // Swish
    private String invoiceNumber; // InvoicePayment
    private String terms; // InvoicePayment
    private String client; // InvoicePayment
    private List<ShoppingItem> items;
    private double total;
    private double discountSum;
    private ReceiptFormatter formatter;

    public Receipt(Builder builder) {
        this.paymentMethod = builder.paymentMethod;
        this.receiptNumber = builder.receiptNumber;
        this.cardNumber = builder.cardNumber;
        this.phoneNumber = builder.phoneNumber;
        this.invoiceNumber = builder.invoiceNumber;
        this.terms = builder.terms;
        this.client = builder.client;
        this.items = builder.items;
        this.total = builder.total;
        this.discountSum = builder.discountSum;
        this.formatter = builder.formatter;
    }

    public double getDiscountSum() {
        return discountSum;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public double getTotal() {
        return total;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getTerms() { return terms; }

    public String shoppingItemsToString() {
        if(items.isEmpty()) return "No items\n";
        StringBuilder sb = new StringBuilder();

        for(ShoppingItem item : items) {
            sb.append(String.format("%-17s %8.2f\n", item.getName(), item.getPrice()));
        }

        return sb.toString();
    }

    @Override
    public String toString(){
        return formatter.format(this);
    }

    public static class Builder {
        private String paymentMethod;
        private String receiptNumber;
        private String invoiceNumber;
        private String cardNumber;
        private String phoneNumber;
        private String terms;
        private String client;
        private List<ShoppingItem> items;
        private double total;
        private double discountSum;
        private ReceiptFormatter formatter;

        public Builder paymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder receiptNumber(String receiptNumber) {
            this.receiptNumber = receiptNumber;
            return this;
        }

        public Builder cardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder invoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }

        public Builder terms(String terms) {
            this.terms = terms;
            return this;
        }

        public Builder client(String contactPerson) {
            this.client = contactPerson;
            return this;
        }

        public Builder items(List<ShoppingItem> items) {
            this.items = items;
            return this;
        }

        public Builder total(double total) {
            this.total = total;
            return this;
        }

        public Builder discountSum(double discountSum) {
            this.discountSum = discountSum;
            return this;
        }

        public Builder formatter(ReceiptFormatter formatter) {
            this.formatter = formatter;
            return this;
        }

        public Receipt build() {
            return new Receipt(this);
        }
    }
}
