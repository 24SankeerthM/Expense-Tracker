package com.expensetracker.model;

/**
 * Represents a monthly spending budget for a specific category.
 * Extends Transaction, so id, category, and month come from the parent class (INHERITANCE).
 */
public class Budget extends Transaction {

    private final double limit;

    public Budget(String id, String category, String month, double limit) {
        super(id, category, month);
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

    @Override
    public String getType() {
        return "Budget";
    }

    @Override
    public String getDetails() {
        return super.getDetails() + String.format(" | Limit: Rs. %.2f", limit);
    }

    @Override
    public String toString() {
        return getDetails();
    }
}
