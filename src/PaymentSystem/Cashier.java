package PaymentSystem;

import PaymentSystem.Catalog.*;
import PaymentSystem.MenuSystem.MenuItem;
import PaymentSystem.MenuSystem.MenuSystem;
import PaymentSystem.Catalog.Catalog;
import PaymentSystem.Catalog.FoodItem;
import PaymentSystem.Catalog.ShoppingItem;
import PaymentSystem.Payment.CardPayment;
import PaymentSystem.Payment.InvoicePayment;
import PaymentSystem.Payment.Payment;
import PaymentSystem.Payment.SwishPayment;
import PaymentSystem.shoppingCart.ShoppingCart;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



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
                new MenuItem("3. Ta bort vara", 3, this::addProduct),
                new MenuItem("4. Betala", 4, this::pay)
        )), true);
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

        addProductsToPayment(invoicePayment);

        String receipt = invoicePayment.processPayment(100);

        payments.add(invoicePayment);


        System.out.println(receipt);
    }

    private void addProductsToPayment(Payment payment) {

        payment.addItem(new ClothingItem("Kofta", 200, "m"));
        payment.addItem(new ClothingItem("Sockar", 60, "38-42"));
        payment.addItem(new ElectricItem("Brödrost", 150, "C"));
        payment.addItem(new FoodItem("Bullar", 35, "2025-09-30"));
    }


        //payments.get(0).refund(50);

    private void handleSwishPayment() {
        System.out.println("--- Skriv ditt telefonnummer ---");
        String phoneNumber = scanner.nextLine();
        Catalog catalog = new Catalog();

        SwishPayment swishPayment = new SwishPayment(phoneNumber);

        addProductsToPayment(swishPayment);

        String receipt = swishPayment.processPayment(100);
        System.out.println(receipt);
    }

    private void handleCardPayment() {
        System.out.println("--- Skriv in ditt kortnummer ---");
        String cardNumber = scanner.nextLine();

        System.out.println("--- Skriv in ditt CVV ---");
        String CVV = scanner.nextLine();

        CardPayment cardPayment = new CardPayment(cardNumber, CVV);

        addProductsToPayment(cardPayment);

        String receipt = cardPayment.processPayment(100);
        System.out.println(receipt);
    }

    private void addProduct() {
        System.out.println("--- Skriv in id på varan ---");
        int itemId = scanner.nextInt();

//        System.out.println("--- Skriv in antal ---");
//        int

        //shoppingCart.addItem(catalog.orderShoppingItem(itemId, 1));
    }

    private void showCatalog() {
        catalog.printCatalog();
    }

}