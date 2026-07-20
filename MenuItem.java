// MenuItem.java
// ---------------------------------------------------------------------------
// Represents ONE item on the restaurant menu.
//
// This is the SHARED data class that the whole group agreed on. Menu, Order,
// and RestaurantApp all depend on it, so please do NOT rename the fields or
// methods without telling everyone first.
// ---------------------------------------------------------------------------

public class MenuItem {

    // ---- Attributes (data members) ----
    private int id;           // unique number used to look the item up, e.g. 3
    private String name;      // e.g. "Cheeseburger"
    private double price;     // e.g. 8.99
    private String category;  // e.g. "Appetizer", "Main", "Drink", "Dessert"

    // ---- Constructor: sets all four fields when the object is created ----
    public MenuItem(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // ---- Getters (return values) ----
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    // Returns one neat line describing this item, e.g.
    //   "2    Cheeseburger         $  8.99  (Main)"
    @Override
    public String toString() {
        return String.format("%-4d %-20s $%6.2f  (%s)", id, name, price, category);
    }
}
