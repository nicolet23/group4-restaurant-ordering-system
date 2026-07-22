// Order.java
// ---------------------------------------------------------------------------
// OWNER: Rakibul
//
// Represents ONE customer's order (their "cart"). It stores the MenuItems the
// customer has chosen in an ArrayList, adds up the cost (with tax), and prints
// a receipt.
// ---------------------------------------------------------------------------

import java.util.ArrayList;

public class Order {

    // The items this customer has ordered so far
    private ArrayList<MenuItem> orderedItems = new ArrayList<>();

    // Tax rate used by calculateTotal(). 0.09 means 9%.
    private static final double TAX_RATE = 0.09;

    // Add one item to the order.
    public void addItem(MenuItem item) {
        orderedItems.add(item);
    }

    // Remove the first item that has the given id.
    // Return true if an item was removed, or false if none matched.
    public boolean removeItem(int id) {
        for (int i = 0; i < orderedItems.size(); i++) {
            if (orderedItems.get(i).getId() == id) {
                orderedItems.remove(i);
                return true;
            }
        }
        return false;
    }

    // Add up the price of every ordered item (before tax) and return it.
    public double calculateSubtotal() {
        double subtotal = 0.0;
        for (MenuItem item : orderedItems) {
            subtotal += item.getPrice();
        }
        return subtotal;
    }

    // Return the subtotal plus tax.
    public double calculateTotal() {
        double subtotal = calculateSubtotal();
        return subtotal + (subtotal * TAX_RATE);
    }

    // Print a receipt: list each ordered item, then the subtotal, tax, and total.
    public void printReceipt() {
        if (orderedItems.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }
        for (MenuItem item : orderedItems) {
            System.out.println(item);
        }
        double subtotal = calculateSubtotal();
        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("Tax (9%%): $%.2f%n", subtotal * TAX_RATE);
        System.out.printf("Total:    $%.2f%n", calculateTotal());
    }

    // -----------------------------------------------------------------------
    // STANDALONE TEST — run this file on its own to check the Order class.
    // -----------------------------------------------------------------------
    public static void main(String[] args) {
        Order order = new Order();
        order.addItem(new MenuItem(2, "Cheeseburger", 8.99, "Main"));
        order.addItem(new MenuItem(3, "Iced Tea", 2.49, "Drink"));

        System.out.println("--- Receipt ---");
        order.printReceipt();

        System.out.println("\nRemove item 3 (expect true):  " + order.removeItem(3));
        System.out.println("Remove item 9 (expect false): " + order.removeItem(9));
    }
}
