package com.expensetracker.exception;

/**
 * Thrown when an expense with the requested ID or index is not found.
 */
public class ExpenseNotFoundException extends Exception {

    public ExpenseNotFoundException(String message) {
        super(message);
    }
}
