// Menu.java
// ---------------------------------------------------------------------------
// OWNER: Runhan Tang
//
// Holds every MenuItem the restaurant offers, stored in an ArrayList, and can
// display them or search for one by id or category.
// ---------------------------------------------------------------------------

import java.util.ArrayList;

public class Menu {

    // The list that stores all of the menu's items
    private ArrayList<MenuItem> items = new ArrayList<>();

    // Add one item to the menu.
    public void addItem(MenuItem item) {
        items.add(item);
    }

    // Print every item on the menu, one per line.
    public void displayMenu() {
        if (items.isEmpty()) {
            System.out.println("The menu is empty.");
            return;
        }
        for (MenuItem item : items) {   // repetition structure
            System.out.println(item);
        }
    }

    // Search the menu for the item with this id.
    // Return that MenuItem, or return null if no item has that id.
    public MenuItem findItemById(int id) {
        for (MenuItem item : items) {
            if (item.getId() == id) {   // decision structure
                return item;
            }
        }
        return null;
    }

    // Print only the items whose category matches the one passed in.
    public void displayByCategory(String category) {
        for (MenuItem item : items) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                System.out.println(item);
            }
        }
    }

    // -----------------------------------------------------------------------
    // STANDALONE TEST — run this file on its own to check the Menu class.
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
