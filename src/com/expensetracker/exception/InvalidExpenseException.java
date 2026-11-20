package com.expensetracker.exception;

/**
 * Thrown when an expense has invalid data, such as a non-positive amount or missing fields.
 */
public class InvalidExpenseException extends Exception {

    public InvalidExpenseException(String message) {
        super(message);
    }
}
