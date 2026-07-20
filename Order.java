// Order.java
// ---------------------------------------------------------------------------
// OWNER: Rakibul
//
// Represents ONE customer's order (their "cart"). It stores the MenuItems the
// customer has chosen in an ArrayList, adds up the cost, and prints a receipt.
//
// HOW TO WORK ON THIS FILE:
//   - Fill in the method bodies wherever you see "// TODO".
//   - You can run THIS file by itself (it has its own main at the bottom) to
//     test your work before the whole project is put together.
//   - Keep the method names and parameters the same as below (the group
//     agreed on them); just write what goes inside.
// ---------------------------------------------------------------------------

import java.util.ArrayList;

public class Order {

    // The items this customer has ordered so far
    private ArrayList<MenuItem> orderedItems = new ArrayList<>();

    // Tax rate used by calculateTotal(). 0.09 means 9%. Adjust if you like.
    private static final double TAX_RATE = 0.09;

    // Add one item to the order.
    public void addItem(MenuItem item) {
        // TODO: add 'item' to orderedItems
    }

    // Remove the first item that has the given id.
    // Return true if an item was removed, or false if none matched.
    public boolean removeItem(int id) {
        // TODO: loop through orderedItems; if you find one whose getId() == id,
        //       remove it and return true. If none match, return false.
        return false;   // placeholder
    }

    // Add up the price of every ordered item (before tax) and return it.
    public double calculateSubtotal() {
        double subtotal = 0.0;
        // TODO: loop through orderedItems and add each item's getPrice() to subtotal
        return subtotal;
    }

    // Return the subtotal plus tax.
    public double calculateTotal() {
        // TODO: get the subtotal, then return subtotal + (subtotal * TAX_RATE)
        return 0.0;
    }

    // Print a receipt: list each ordered item, then the subtotal, the tax
    // amount, and the final total.
    public void printReceipt() {
        // TODO: loop through orderedItems and print each one, then print
        //       calculateSubtotal(), the tax, and calculateTotal()
        System.out.println("(printReceipt not implemented yet)");
    }

    // -----------------------------------------------------------------------
    // STANDALONE TEST — run this file on its own to check your own work.
    // -----------------------------------------------------------------------
    public static void main(String[] args) {
        Order order = new Order();
        order.addItem(new MenuItem(2, "Cheeseburger", 8.99, "Main"));
        order.addItem(new MenuItem(3, "Iced Tea", 2.49, "Drink"));

        System.out.println("Subtotal (expect 11.48): " + order.calculateSubtotal());
        System.out.println("Total with tax:          " + order.calculateTotal());

        System.out.println("\n--- Receipt ---");
        order.printReceipt();

        System.out.println("\nRemove item 3 (expect true):  " + order.removeItem(3));
        System.out.println("Remove item 9 (expect false): " + order.removeItem(9));
    }
}
