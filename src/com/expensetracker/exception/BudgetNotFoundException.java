package com.expensetracker.exception;

/**
 * Thrown when trying to check or query a budget that does not exist.
 */
public class BudgetNotFoundException extends Exception {

    public BudgetNotFoundException(String message) {
        super(message);
    }
}
