package PaymentSystem.Payment;

import java.util.Date;

public class InvoiceFormatter implements ReceiptFormatter{
    @Override
    public String format(Receipt receipt) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("----- INVOICE -----").append("\n");
        sb.append(new Date()).append("\n");
        sb.append("Invoice number: ").append(receipt.getInvoiceNumber()).append("\n");
        sb.append("Terms of payment: ").append(receipt.getTerms()).append("\n\n");
        sb.append(receipt.shoppingItemsToString()).append("\n");
        sb.append(String.format("%-7s %15.2fKr\n", "Rabatt: ", receipt.getDiscountSum()));
        sb.append((String.format("%-7s %16.2fKr\n", "TOTAL: ", receipt.getTotal())));
        sb.append("==========================\n");
        sb.append(String.format("Payment method: %s\n", receipt.getPaymentMethod()));
        sb.append("Contact: ").append(receipt.getPhoneNumber()).append("\n");

        return sb.toString();
    }
}
