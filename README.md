# Expense Tracker & Budget Planner

A console-based Java application to track daily expenses, set monthly budgets, and view spending summaries and trends.

## Features
- Add, view, and delete expenses by category and month
- Set monthly budgets per category
- Check if spending exceeds budget
- Monthly summary with category breakdown
- Spending trend across all months
- All-time category totals

## How to Run

```bash
cd src
javac *.java
java Main
```

## Project Structure

| File | Responsibility |
|---|---|
| `Expense.java` | Data model for a single expense |
| `Budget.java` | Data model for a monthly budget |
| `ExpenseManager.java` | Add, view, delete, filter expenses |
| `BudgetManager.java` | Set, view, check budgets |
| `SummaryManager.java` | Summaries, trends, category totals |
| `Main.java` | Console menu, entry point |

## Notes
- Data is stored in memory only (resets on restart)
- Month format: `YYYY-MM` (e.g. `2024-01`)
- No GUI, no database — console only
