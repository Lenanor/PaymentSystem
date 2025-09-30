package PaymentSystem.MenuSystem;

import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuSystem {

    private MenuSystem() {
    }

    public static void displayMenu(Scanner scanner, String title, ArrayList<MenuItem> menuItems) {

        int choice;

        while (true) {
            System.out.println(title);

            for (MenuItem menuItem : menuItems) {
                System.out.println(menuItem.getLabel());
            }

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException exception) {
                System.out.println("Wrong input choice");
                scanner.nextLine();
                continue;
            }

            if (choice == 0){
                return;
            }

            MenuItem selected = getMenuItem(menuItems, choice);

            if (selected != null)
                selected.getAction().run();
            else
                System.out.println("Wrong input choice");
        }
    }

    private static MenuItem getMenuItem(ArrayList<MenuItem> menuItems, int choice) {
        for (MenuItem menuItem : menuItems){
            if (menuItem.getInputChoice() == choice){
                return menuItem;
            }
        }
        return null;
    }
}
