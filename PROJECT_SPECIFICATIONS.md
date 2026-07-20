# Project Specifications Document

**Course:** Computer Science I (Java)
**Group 4:** Runhan Tang, Yiru Sun, Rakibul Hasan Safi, Jahson Westby
**Project:** Restaurant Ordering System (console application)

---

## 1. Purpose

The purpose of this project is to build a console-based **Restaurant Ordering
System** in Java. A user can browse a restaurant menu, add items to an order,
remove items, and check out with an itemized receipt that includes tax.

The project lets our group practice and demonstrate the core skills from the
course — decision structures, loops, ArrayLists, classes and objects, and
user-defined methods — while also giving us experience working together as a
development team using GitHub.

## 2. Main Features

- **View the menu** — display every item with its id, name, price, and category.
- **Add to order** — the user enters an item's id and it is added to their order.
- **Remove from order** — the user can remove an item from their order by id.
- **Checkout** — print an itemized receipt showing each item, the subtotal, the
  tax, and the final total.
- **Input validation** — if the user types something that is not a valid number,
  the program asks again instead of crashing.
- **Sample menu data** — the program loads a set of starter menu items so it is
  ready to use.

## 3. Classes Used

| Class | Responsibility |
|-------|----------------|
| `MenuItem` | Data model for a single menu item: id, name, price, category. |
| `Menu` | Stores all `MenuItem`s in an `ArrayList`; displays and searches them. |
| `Order` | The customer's cart: adds/removes items, totals the cost, prints the receipt. |
| `RestaurantApp` | The main program: runs the console menu loop and connects `Menu` and `Order`. |
| `Discount` *(optional helper)* | Applies a percentage coupon to an order total. |

---

## Required Concepts — where each one appears

| Required concept | Where it is used |
|------------------|------------------|
| Decision structures (`if` / `else if` / `else`) | `RestaurantApp` menu choices; `Menu.findItemById`; `Order.removeItem`. |
| Repetition structure (`for` / `while`) | `RestaurantApp` main `while` loop; `for` loops throughout `Menu` and `Order`. |
| Array or ArrayList | `Menu` and `Order` each store items in an `ArrayList<MenuItem>`. |
| Classes and objects (attributes + methods) | All five classes; objects are created from `MenuItem`, `Menu`, and `Order`. |
| User-defined methods (parameters + return values) | e.g. `findItemById(int)` returns a `MenuItem`; `calculateTotal()` returns a `double`. |

## Task Assignments

| Member | Responsibility |
|--------|----------------|
| Yiru Sun | `Menu` class (stores, displays, and searches menu items). |
| Rakibul Hasan Safi | `Order` class (cart, totals, and receipt). |
| Runhan Tang | `RestaurantApp` main program and integration. |
| Jahson Westby | This specifications document, the sample menu data, the optional `Discount` helper, and testing the finished program. |

*The `MenuItem` class is a shared data class that the whole group agreed on;
its fields and method names are fixed so that everyone's code fits together.*
