// Expense.java - Data model representing a single expense entry
// Fields: category, description, amount, date (YYYY-MM format)

public class Expense {

    private String category;
    private String description;
    private double amount;
    private String date;

    // Constructor to initialize all fields
    public Expense(String category, String description, double amount, String date) {
        this.category    = category;
        this.description = description;
        this.amount      = amount;
        this.date        = date;
    }

    // Getters - allow other classes to read private fields
    public String getCategory()    { return category; }
    public String getDescription() { return description; }
    public double getAmount()      { return amount; }
    public String getDate()        { return date; }

    // toString - prints a readable one-line summary of the expense
    @Override
    public String toString() {
        return String.format("[%s] %s - %s : Rs. %.2f", date, category, description, amount);
    }
}
