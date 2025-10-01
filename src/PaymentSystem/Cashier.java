package PaymentSystem;

import PaymentSystem.Catalog.*;
import PaymentSystem.MenuSystem.MenuItem;
import PaymentSystem.MenuSystem.MenuSystem;
import PaymentSystem.Payment.CardPayment;
import PaymentSystem.Payment.InvoicePayment;
import PaymentSystem.Payment.Payment;
import PaymentSystem.Payment.SwishPayment;
import PaymentSystem.shoppingCart.ShoppingCart;

import java.util.*;

public class Cashier {
    private List<Payment> payments;
    private Map<String, Payment> processedPayments;
    private Scanner scanner;
    private Catalog catalog;
    private ShoppingCart shoppingCart;

    public Cashier() {

        payments = new ArrayList<>();
        processedPayments = new HashMap<>();
        scanner = new Scanner(System.in);
        catalog = new Catalog();
        shoppingCart = new ShoppingCart();

//        payments = new ArrayList<>();
//        processedPayments = new HashMap<>();
//
//        payments.add(new CardPayment("123456789", ""));
//        payments.get(0).addItem(new ShoppingItem("Bullar", 35));
//        payments.get(0).addItem(new ShoppingItem("Kakor", 25));
//        payments.get(0).addItem(new ShoppingItem("Kaffe", 40));
//
//        payments.add(new SwishPayment("123"));
//        payments.add(new InvoicePayment("Viola Bengtsson"));
//
//        for (Payment payment : payments){
//            processedPayments.put(payment.processPayment(payment.getTotalSum()), payment);
//        }
//
//        payments.get(0).refund(50);
//
//        Catalog catalog = new Catalog();
//
//        catalog.printCatalog();
//        catalog.orderShoppingItem(1, 100);
//        catalog.printCatalog();
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
                )));
    }

    private void pay() {
        displayPay();
    }

    private void displayPay() {
        MenuSystem.displayMenu(scanner, "--- Välj betalmetod ---", new ArrayList<>(List.of(
                new MenuItem("1. Kort", 1, this::handleCardPayment),
                new MenuItem("2. Swish", 2, this::handleSwishPayment),
                new MenuItem("3. Faktura", 3, this::handleInvoicePayment)
                )));
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

    private void handleSwishPayment() {
        System.out.println("--- Skriv ditt telefonnummer ---");
        String phoneNumber = scanner.nextLine();

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

    }

    private void showCatalog() {
        catalog.printCatalog();
    }
}
