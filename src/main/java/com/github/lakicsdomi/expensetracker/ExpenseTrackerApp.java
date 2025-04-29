package com.github.lakicsdomi.expensetracker;

import com.github.lakicsdomi.expensetracker.service.ExpenseManager;
import com.github.lakicsdomi.expensetracker.model.Category;

import java.time.LocalDate;
import java.util.Scanner;

public class ExpenseTrackerApp {
    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Expense Tracker!");

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addExpense(scanner, expenseManager);
                case "2" -> listExpenses(expenseManager);
                case "3" -> listExpensesByCategory(scanner, expenseManager);
                case "4" -> listExpensesByDate(scanner, expenseManager);
                case "5" -> printTotalSpending(expenseManager);
                case "6" -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Add Expense");
        System.out.println("2. List Expenses");
        System.out.println("3. List Expenses by Category");
        System.out.println("4. List Expenses by Date");
        System.out.println("5. Total Spending");
        System.out.println("6. Exit");
    }

    private static void addExpense(Scanner scanner, ExpenseManager expenseManager) {
        try {
            System.out.print("Enter amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            printCategories();
            System.out.print("Enter category: ");
            String categoryInput = scanner.nextLine();

            Category category = Category.valueOf(categoryInput.toUpperCase());
            System.out.print("Enter description: ");
            String description = scanner.nextLine();

            expenseManager.addExpense(amount, category, description);
            System.out.println("Expense added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid category. Please try again.");
        }
    }

    private static void listExpenses(ExpenseManager expenseManager) {
        var expenses = expenseManager.getExpenses();
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("Listing all expenses:");
            expenses.forEach(System.out::println);
        }
    }

    private static void listExpensesByCategory(Scanner scanner, ExpenseManager expenseManager) {
        printCategories();
        System.out.print("Enter category: ");
        String categoryInput = scanner.nextLine();

        try {
            Category category = Category.valueOf(categoryInput.toUpperCase());
            var expenses = expenseManager.getExpensesByCategory(category);
            if (expenses.isEmpty()) {
                System.out.println("No expenses found for category: " + category);
            } else {
                System.out.println("Listing expenses for category: " + category);
                expenses.forEach(System.out::println);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid category. Please try again.");
        }
    }

    private static void listExpensesByDate(Scanner scanner, ExpenseManager expenseManager) {
        System.out.print("Enter date (YYYY-MM-DD): ");
        String dateInput = scanner.nextLine();

        try {
            LocalDate date = LocalDate.parse(dateInput);
            var expenses = expenseManager.getExpensesByDateRange(date, date);
            if (expenses.isEmpty()) {
                System.out.println("No expenses found for date: " + date);
            } else {
                System.out.println("Listing expenses for date: " + date);
                expenses.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use the format YYYY-MM-DD.");
        }
    }

    private static void printTotalSpending(ExpenseManager expenseManager) {
        double total = expenseManager.getTotalExpenses();
        System.out.printf("Total spending: %.2f%n", total);
    }

    private static void printCategories() {
        System.out.println("Available Categories:");
        for (Category category : Category.values()) {
            System.out.println("- " + category.name().toLowerCase());
        }
    }
}
