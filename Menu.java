// Menu.java
// ---------------------------------------------------------------------------
// OWNER: Yiru
//
// Holds every MenuItem the restaurant offers, stored in an ArrayList.
//
// HOW TO WORK ON THIS FILE:
//   - Fill in the method bodies wherever you see "// TODO".
//   - You can run THIS file by itself (it has its own main at the bottom) to
//     test your work before the whole project is put together.
//   - The method names and parameters are already agreed on by the group,
//     so please keep them the same; just write what goes inside.
// ---------------------------------------------------------------------------

import java.util.ArrayList;

public class Menu {

    // The list that stores all of the menu's items
    private ArrayList<MenuItem> items = new ArrayList<>();

    // Add one item to the menu.
    public void addItem(MenuItem item) {
        // TODO: add 'item' to the items list
    }

    // Print every item on the menu, one per line.
    public void displayMenu() {
        // TODO: use a for loop to go through 'items' and print each one
        System.out.println("(displayMenu not implemented yet)");
    }

    // Search the menu for the item with this id.
    // Return that MenuItem, or return null if no item has that id.
    public MenuItem findItemById(int id) {
        // TODO: loop through 'items'; if an item's getId() == id, return that item
        return null;   // placeholder so the file still compiles
    }

    // Print only the items whose category matches the one passed in.
    public void displayByCategory(String category) {
        // TODO: loop through 'items'; print each item whose getCategory() equals category
        //       (use an if statement inside the loop)
        System.out.println("(displayByCategory not implemented yet)");
    }

    // -----------------------------------------------------------------------
    // STANDALONE TEST — run this file on its own to check your own work.
    // (This main is only used when you run Menu directly; RestaurantApp has
    //  its own main and does not use this one.)
    // -----------------------------------------------------------------------
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addItem(new MenuItem(1, "Spring Rolls", 5.99, "Appetizer"));
        menu.addItem(new MenuItem(2, "Cheeseburger", 8.99, "Main"));
        menu.addItem(new MenuItem(3, "Iced Tea", 2.49, "Drink"));

        System.out.println("--- Full menu ---");
        menu.displayMenu();

        System.out.println("\n--- Find item 2 (should be the Cheeseburger) ---");
        System.out.println(menu.findItemById(2));

        System.out.println("\n--- Drinks only ---");
        menu.displayByCategory("Drink");
    }
}
