// RestaurantApp.java
// ---------------------------------------------------------------------------
// OWNER: Runhan
//
// The MAIN program. It builds the menu, then runs a console loop that lets the
// user view the menu, add and remove items from their order, and check out
// with a receipt.
//
// This file ties Menu and Order together. It will run right away, but the
// menu/order actions only do something once Yiru and Rakibul finish filling
// in Menu.java and Order.java.
// ---------------------------------------------------------------------------

import java.util.Scanner;

public class RestaurantApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        Order order = new Order();

        // A few coupon codes the customer can use at checkout.
        // (This is an ARRAY of Discount objects.)
        Discount[] coupons = {
            new Discount("STUDENT10", 0.10),   // 10% off
            new Discount("WELCOME5", 0.05)     // 5% off
        };

        // Fill the menu with some starter items so it isn't empty.
        // (Jahson: this is placeholder data — feel free to replace it with the
        //  fuller sample menu you create.)
        loadSampleMenu(menu);

        System.out.println("===== Welcome to the Group 4 Restaurant =====");

        boolean running = true;
        while (running) {                       // repetition structure
            printOptions();
            int choice = readInt(input, "Choose an option (1-6): ");

            if (choice == 1) {                  // decision structure
                System.out.println("\n----- MENU -----");
                menu.displayMenu();

            } else if (choice == 2) {
                int id = readInt(input, "Enter the id of the item to add: ");
                MenuItem item = menu.findItemById(id);
                if (item != null) {
                    order.addItem(item);
                    System.out.println("Added: " + item.getName());
                } else {
                    System.out.println("No item found with id " + id + ".");
                }

            } else if (choice == 3) {
                int id = readInt(input, "Enter the id of the item to remove: ");
                if (order.removeItem(id)) {
                    System.out.println("Item removed.");
                } else {
                    System.out.println("That item was not in your order.");
                }

            } else if (choice == 4) {
                // Show the order so far without ending the program.
                System.out.println("\n----- YOUR CURRENT ORDER -----");
                order.printReceipt();

            } else if (choice == 5) {
                System.out.println("\n----- RECEIPT -----");
                order.printReceipt();

                // Ask for an optional coupon code and apply it if it matches.
                double total = order.calculateTotal();
                String code = readLine(input, "Enter a coupon code (or press Enter to skip): ");
                if (!code.isEmpty()) {
                    Discount applied = null;
                    for (Discount d : coupons) {      // search the array
                        if (d.matches(code)) {
                            applied = d;
                        }
                    }
                    if (applied != null) {
                        System.out.printf("Coupon %s applied! You saved $%.2f%n",
                                          applied.getCode(), applied.amountOff(total));
                        System.out.printf("New total: $%.2f%n", applied.applyTo(total));
                    } else {
                        System.out.println("Coupon code not recognized. No discount applied.");
                    }
                }

                System.out.println("Thank you for your order!");
                running = false;

            } else if (choice == 6) {
                System.out.println("Goodbye!");
                running = false;

            } else {
                System.out.println("Please enter a number from 1 to 6.");
            }
            System.out.println();
        }

        input.close();
    }

    // Fills the menu with a few sample items so the program is usable.
    private static void loadSampleMenu(Menu menu) {
        menu.addItem(new MenuItem(1, "Spring Rolls",     5.99, "Appetizer"));
        menu.addItem(new MenuItem(2, "Cheeseburger",     8.99, "Main"));
        menu.addItem(new MenuItem(3, "Margherita Pizza", 11.50, "Main"));
        menu.addItem(new MenuItem(4, "Iced Tea",         2.49, "Drink"));
        menu.addItem(new MenuItem(5, "Chocolate Cake",   4.75, "Dessert"));
    }

    // Prints the list of choices each time through the loop.
    private static void printOptions() {
        System.out.println("1. View menu");
        System.out.println("2. Add item to order");
        System.out.println("3. Remove item from order");
        System.out.println("4. View current order");
        System.out.println("5. Checkout");
        System.out.println("6. Quit");
    }

    // Reads a whole number from the user. If they type something that is not a
    // number, it asks again instead of crashing. Returns the number entered.
    // Reading a full line (instead of nextInt) keeps number input and text
    // input (like the coupon code) from interfering with each other.
    private static int readInt(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {   // exception handling
                System.out.println("Please enter a whole number.");
            }
        }
    }

    // Reads a line of text from the user and returns it (trimmed).
    private static String readLine(Scanner input, String prompt) {
        System.out.print(prompt);
        return input.nextLine().trim();
    }
}
