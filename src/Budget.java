// ============================================================
// FILE: Budget.java
// PURPOSE: Represents a monthly budget for a specific category.
//          Stores how much is ALLOWED to be spent.
// AUTHOR SECTION: Team Member responsible for budget logic
// ============================================================

public class Budget {

    // ----- Fields -----
    private String category;  // Which category this budget applies to
    private String month;     // Which month, e.g. "2024-01"
    private double limit;     // The maximum allowed spend for this category+month

    // ----- Constructor -----
    public Budget(String category, String month, double limit) {
        this.category = category;
        this.month    = month;
        this.limit    = limit;
    }

    // ----- Getters -----
    public String getCategory() { return category; }
    public String getMonth()    { return month; }
    public double getLimit()    { return limit; }

    // ----- toString: readable summary -----
    @Override
    public String toString() {
        return String.format("[%s] %s budget : Rs. %.2f", month, category, limit);
    }
}
