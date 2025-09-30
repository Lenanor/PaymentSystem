package PaymentSystem.Payment;

public class SwishReceiptFormatter implements ReceiptFormatter {
    @Override
    public String format(Receipt receipt) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("----- RECEIPT -----").append("\n");
        sb.append("Receipt number: ").append(receipt.getReceiptNumber()).append("\n\n");
        sb.append(receipt.shoppingItemsToString()).append("\n");
        sb.append((String.format("%-7s %16.2fKr\n", "TOTAL: ", receipt.getTotal())));
        sb.append("==========================\n");
        sb.append(String.format("Payment method: %s\n", receipt.getPaymentMethod()));
        sb.append("Phone number: ").append(receipt.getPhoneNumber()).append("\n");

        return sb.toString();
    }
}
