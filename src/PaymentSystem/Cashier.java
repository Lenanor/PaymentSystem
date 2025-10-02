package PaymentSystem;

import PaymentSystem.Catalog.*;
import PaymentSystem.MenuSystem.MenuItem;
import PaymentSystem.MenuSystem.MenuSystem;
import PaymentSystem.Catalog.Catalog;
import PaymentSystem.Catalog.FoodItem;
import PaymentSystem.Payment.*;
import PaymentSystem.shoppingCart.Order;
import PaymentSystem.shoppingCart.ShoppingCart;
import java.util.*;
import java.util.ArrayList;
import java.util.List;


public class Cashier {

    private List<Payment> payments;
    private Catalog catalog;
    private ShoppingCart shoppingCart;

    private Scanner scanner;

    public Cashier() {
        catalog = new Catalog();
        shoppingCart = new ShoppingCart();
        scanner = new Scanner(System.in);
    }

    public void start(){
        startMainMenu();
    }

    private void startMainMenu() {

        MenuSystem.displayMenu(scanner, "--- Meny ---", new ArrayList<>(List.of(
                new MenuItem("1. Visa katalogen", 1, this::showCatalog),
                new MenuItem("2. Lägg till vara", 2, this::addProduct),
                new MenuItem("3. Ta bort vara", 3, this::removeProduct),
                new MenuItem("4. Betala", 4, this::pay)
        )), true);
    }

    private void removeProduct() {
        System.out.println("--- Skriv in id på ");
        //shoppingCart.removeItem()
    }

    private void pay() {
        displayPay();
    }
//        payments.add(new CardPayment("123456789", ""));
//        payments.get(0).addItem(new ShoppingItem("Bullar", 35));
//        payments.get(0).addItem(new ShoppingItem("Kakor", 25));
//        payments.get(0).addItem(new ShoppingItem("Kaffe", 40));

    private void displayPay() {
        MenuSystem.displayMenu(scanner, "--- Välj betalmetod ---", new ArrayList<>(List.of(
                new MenuItem("1. Kort", 1, this::handleCardPayment),
                new MenuItem("2. Swish", 2, this::handleSwishPayment),
                new MenuItem("3. Faktura", 3, this::handleInvoicePayment)
        )), false);
    }

    private void handleInvoicePayment() {
        System.out.println("--- Skriv ditt fullständiga namn ---");
        String fullName = scanner.nextLine();

        InvoicePayment invoicePayment = new InvoicePayment(fullName);

        makeOrderToPayment(invoicePayment);

        Receipt receipt = invoicePayment.processPayment();

        // payments.add(invoicePayment);

        System.out.println(receipt);
    }

    private void makeOrderToPayment(Payment payment) {
        Order order = shoppingCart.makeOrder();
        payment.setOrder(order);
        payment.setDiscount(new PercentageDiscount(30));
    }


        //payments.get(0).refund(50);

    private void handleSwishPayment() {
        System.out.println("--- Skriv ditt telefonnummer ---");
        String phoneNumber = scanner.nextLine();
        Catalog catalog = new Catalog();

        SwishPayment swishPayment = new SwishPayment(phoneNumber);

        makeOrderToPayment(swishPayment);

        Receipt receipt = swishPayment.processPayment();
        System.out.println(receipt);
    }

    private void handleCardPayment() {
        System.out.println("--- Skriv in ditt kortnummer ---");
        String cardNumber = scanner.nextLine();

        System.out.println("--- Skriv in ditt CVV ---");
        String CVV = scanner.nextLine();

        CardPayment cardPayment = new CardPayment(cardNumber, CVV);

        makeOrderToPayment(cardPayment);

        Receipt receipt = cardPayment.processPayment();
        System.out.println(receipt);
    }

    private void addProduct() {
        System.out.println("--- Skriv in id på varan ---");
        int itemId = scanner.nextInt();

//        System.out.println("--- Skriv in antal ---");
//        int

        shoppingCart.addItem(catalog.orderShoppingItem(itemId, 1));
    }

    private void showCatalog() {
        catalog.printCatalog();
    }

}