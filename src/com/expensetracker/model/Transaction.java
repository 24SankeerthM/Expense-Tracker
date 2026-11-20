package com.expensetracker.model;

/**
 * Base abstract class for financial records in the tracker.
 *
 * It is abstract because we never instantiate a raw "Transaction".
 * We only create specific records like Expense or Budget (ABSTRACTION).
 */
public abstract class Transaction {

    // private fields - outside classes access these only via getters (ENCAPSULATION)
    private final String id;
    private final String category;
    private final String month;

    public Transaction(String id, String category, String month) {
        this.id = id;
        this.category = category;
        this.month = month;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getMonth() {
        return month;
    }

    // Every child class must define its own record type name
    public abstract String getType();

    // Child classes override this to add their own specific details (POLYMORPHISM)
    public String getDetails() {
        return String.format("[%s] ID: %s | %-12s", month, id, category);
    }
}
