// Discount.java
// ---------------------------------------------------------------------------
// OWNER: Runhan Tang
//
// A simple coupon. Each Discount has a code (like "STUDENT10") and a percentage
// off (like 0.10 for 10% off). The main program keeps a few of these and checks
// whether the code a customer types matches one of them.
// ---------------------------------------------------------------------------

public class Discount {

    // ---- Attributes ----
    private String code;        // the coupon code, e.g. "STUDENT10"
    private double percentOff;  // fraction off, e.g. 0.10 means 10% off

    // ---- Constructor ----
    public Discount(String code, double percentOff) {
        this.code = code;
        this.percentOff = percentOff;
    }

    // ---- Getters ----
    public String getCode() {
        return code;
    }

    public double getPercentOff() {
        return percentOff;
    }

    // Returns true if the code the customer typed matches this coupon.
    // Uses equalsIgnoreCase so "student10" and "STUDENT10" both work.
    public boolean matches(String enteredCode) {
        return code.equalsIgnoreCase(enteredCode);
    }

    // Returns how much money this coupon takes off the given total.
    public double amountOff(double total) {
        return total * percentOff;
    }

    // Returns the new total after this coupon is applied.
    public double applyTo(double total) {
        return total - amountOff(total);
    }

    // -----------------------------------------------------------------------
    // STANDALONE TEST — run this file on its own to check the Discount class.
    // -----------------------------------------------------------------------
    public static void main(String[] args) {
        Discount student = new Discount("STUDENT10", 0.10);

        System.out.println("Code matches 'student10'? " + student.matches("student10"));
        System.out.println("Code matches 'SAVE50'?    " + student.matches("SAVE50"));
        System.out.printf("Amount off $20.00: $%.2f%n", student.amountOff(20.00));
        System.out.printf("New total on $20.00: $%.2f%n", student.applyTo(20.00));
    }
}
