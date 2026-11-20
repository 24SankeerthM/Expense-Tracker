package com.expensetracker.service;

import com.expensetracker.model.Expense;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Computes summaries, breakdowns, and historical spending trends.
 *
 * COLLECTIONS: Uses LinkedHashMap to preserve insertion order for predictable output.
 */
public class SummaryService {

    /**
     * Prints a breakdown of spending by category for a specific month.
     */
    public void printMonthlySummary(String month, ExpenseService es) {
        List<Expense> monthList = es.getByMonth(month);

        if (monthList.isEmpty()) {
            System.out.println("No expenses found for " + month + ".");
            return;
        }

        Map<String, Double> categoryTotals = new LinkedHashMap<>();
        for (Expense e : monthList) {
            categoryTotals.merge(e.getCategory(), e.getAmount(), Double::sum);
        }

        System.out.println("--- Monthly Summary: " + month + " ---");
        double grandTotal = 0;
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            System.out.printf("  %-15s : Rs. %.2f%n", entry.getKey(), entry.getValue());
            grandTotal += entry.getValue();
        }
        System.out.printf("  %-15s : Rs. %.2f%n", "TOTAL", grandTotal);
    }

    /**
     * Compares spending across all recorded months and identifies the highest spending month.
     */
    public void printSpendingTrend(ExpenseService es) {
        List<Expense> all = es.getAll();

        if (all.isEmpty()) {
            System.out.println("No expenses recorded to show trends.");
            return;
        }

        Map<String, Double> monthTotals = new LinkedHashMap<>();
        for (Expense e : all) {
            monthTotals.merge(e.getMonth(), e.getAmount(), Double::sum);
        }

        System.out.println("--- Spending Trend (by Month) ---");
        String peakMonth = null;
        double peakAmount = 0;

        for (Map.Entry<String, Double> entry : monthTotals.entrySet()) {
            System.out.printf("  %s : Rs. %.2f%n", entry.getKey(), entry.getValue());
            if (entry.getValue() > peakAmount) {
                peakAmount = entry.getValue();
                peakMonth = entry.getKey();
            }
        }
        System.out.printf("  Highest spending month: %s (Rs. %.2f)%n", peakMonth, peakAmount);
    }

    /**
     * Prints the all-time spending aggregated by category.
     */
    public void printCategorySummary(ExpenseService es) {
        List<Expense> all = es.getAll();

        if (all.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }

        Map<String, Double> categoryTotals = new LinkedHashMap<>();
        for (Expense e : all) {
            categoryTotals.merge(e.getCategory(), e.getAmount(), Double::sum);
        }

        System.out.println("--- Category-wise Total (All Time) ---");
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            System.out.printf("  %-15s : Rs. %.2f%n", entry.getKey(), entry.getValue());
        }
    }
}
