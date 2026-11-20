// Main.java - Entry point. Handles the console menu using Scanner.
// Ties together ExpenseManager, BudgetManager and SummaryManager.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create one instance of each manager
        ExpenseManager em = new ExpenseManager();
        BudgetManager  bm = new BudgetManager();
        SummaryManager sm = new SummaryManager();

        System.out.println("========================================");
        System.out.println("   Expense Tracker & Budget Planner     ");
        System.out.println("========================================");

        boolean isRunning = true;
        while (isRunning) {
            printMenu();
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {

                // ---- EXPENSE OPERATIONS ----

                case "1":
                    // Collect expense details from the user
                    System.out.print("Category (Food/Transport/Shopping/Bills/Other): ");
                    String cat = scanner.nextLine().trim();
                    System.out.print("Description: ");
                    String desc = scanner.nextLine().trim();
                    System.out.print("Amount (Rs.): ");
                    double amount = Double.parseDouble(scanner.nextLine().trim());
                    System.out.print("Month (YYYY-MM, e.g. 2024-01): ");
                    String date = scanner.nextLine().trim();
                    em.addExpense(cat, desc, amount, date);
                    break;

                case "2":
                    em.viewAllExpenses();
                    break;

                case "3":
                    em.viewAllExpenses();
                    System.out.print("Enter expense number to delete: ");
                    int num = Integer.parseInt(scanner.nextLine().trim());
                    em.deleteExpense(num);
                    break;

                // ---- BUDGET OPERATIONS ----

                case "4":
                    System.out.print("Category: ");
                    String bCat = scanner.nextLine().trim();
                    System.out.print("Month (YYYY-MM): ");
                    String bMonth = scanner.nextLine().trim();
                    System.out.print("Budget Limit (Rs.): ");
                    double limit = Double.parseDouble(scanner.nextLine().trim());
                    bm.setBudget(bCat, bMonth, limit);
                    break;

                case "5":
                    bm.viewAllBudgets();
                    break;

                case "6":
                    System.out.print("Category: ");
                    String chkCat = scanner.nextLine().trim();
                    System.out.print("Month (YYYY-MM): ");
                    String chkMonth = scanner.nextLine().trim();
                    bm.checkBudget(chkCat, chkMonth, em);
                    break;

                // ---- SUMMARY AND TRENDS ----

                case "7":
                    System.out.print("Month (YYYY-MM): ");
                    String sumMonth = scanner.nextLine().trim();
                    sm.monthlySummary(sumMonth, em);
                    break;

                case "8":
                    sm.spendingTrend(em);
                    break;

                case "9":
                    sm.categorySummary(em);
                    break;

                // ---- EXIT ----

                case "0":
                    System.out.println("Goodbye! Exiting Expense Tracker.");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid option. Please choose from the menu.");
            }

            System.out.println(); // blank line between actions for readability
        }

        scanner.close();
    }

    // Prints all menu options neatly
    private static void printMenu() {
        System.out.println("----------------------------------------");
        System.out.println(" EXPENSES");
        System.out.println("  1. Add Expense");
        System.out.println("  2. View All Expenses");
        System.out.println("  3. Delete Expense");
        System.out.println(" BUDGETS");
        System.out.println("  4. Set Budget");
        System.out.println("  5. View All Budgets");
        System.out.println("  6. Check Budget vs Spending");
        System.out.println(" SUMMARIES");
        System.out.println("  7. Monthly Summary");
        System.out.println("  8. Spending Trend (all months)");
        System.out.println("  9. Category-wise Total");
        System.out.println(" 0. Exit");
        System.out.println("----------------------------------------");
    }
}
