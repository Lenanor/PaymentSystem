package PaymentSystem.Payment;

import PaymentSystem.ShoppingItem;

import java.util.List;

public class Receipt {
    private String method;
    private String receiptNumber;
    private String cardNumber;
    private String phoneNumber;
    private String invoiceNumber; // add to InvoicePayment
    private String company; // add to InvoicePayment
    private String contactPerson; // add to InvoicePayment
    private List<ShoppingItem> items;
    private double total;

    public Receipt(Builder builder) {
        this.method = builder.method;
        this.receiptNumber = builder.receiptNumber;
        this.cardNumber = builder.cardNumber;
        this.phoneNumber = builder.phoneNumber;
        this.invoiceNumber = builder.invoiceNumber;
        this.company = builder.company;
        this.contactPerson = builder.contactPerson;
        this.items = builder.items;
        this.total = builder.total;
    }

    public static class Builder {
        private String method;
        private String receiptNumber;
        private String cardNumber;
        private String phoneNumber;
        private String invoiceNumber; // add to InvoicePayment
        private String company; // add to InvoicePayment
        private String contactPerson; // add to InvoicePayment
        private List<ShoppingItem> items;
        private double total;

        private Builder method(String method) {
            this.method = method;
            return this;
        }

        private Builder receiptNumber(String receiptNumber) {
            this.receiptNumber = receiptNumber;
            return this;
        }

        private Builder cardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        private Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        private Builder invoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }

        private Builder company(String company) {
            this.company = company;
            return this;
        }

        private Builder contactPerson(String contactPerson) {
            this.contactPerson = contactPerson;
            return this;
        }

        private Builder items(List<ShoppingItem> items) {
            this.items = items;
            return this;
        }

        private Builder total(double total) {
            this.total = total;
            return this;
        }

        public Receipt build() {
            return new Receipt(this);
        }
    }
}
