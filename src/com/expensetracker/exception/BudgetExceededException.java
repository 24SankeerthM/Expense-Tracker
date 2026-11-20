package com.expensetracker.exception;

/**
 * Thrown when spending in a category exceeds the configured monthly budget limit.
 */
public class BudgetExceededException extends Exception {

    public BudgetExceededException(String message) {
        super(message);
    }
}
