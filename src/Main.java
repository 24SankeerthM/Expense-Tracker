// Main.java - Entry point. Handles the console menu using Scanner.
// Ties together ExpenseManager, BudgetManager and SummaryManager.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("   Expense Tracker & Budget Planner     ");
        System.out.println("========================================");

        boolean isRunning = true;
        while (isRunning) {
            printMenu();
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine().trim();

            // Menu options will be added here
            System.out.println("Coming soon: " + choice);

            if (choice.equals("0")) {
                System.out.println("Goodbye!");
                isRunning = false;
            }
        }

        scanner.close();
    }

    // Prints the full menu to the console
    private static void printMenu() {
        System.out.println("----------------------------------------");
        System.out.println(" 1. Add Expense     2. View Expenses");
        System.out.println(" 3. Delete Expense  4. Set Budget");
        System.out.println(" 5. View Budgets    6. Check Budget");
        System.out.println(" 7. Monthly Summary 8. Spending Trend");
        System.out.println(" 9. Category Total  0. Exit");
        System.out.println("----------------------------------------");
    }
}
