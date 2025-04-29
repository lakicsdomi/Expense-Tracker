package com.github.lakicsdomi.expensetracker;
import java.util.Scanner;
import com.github.lakicsdomi.expensetracker.service.ExpenseManager;
import com.github.lakicsdomi.expensetracker.model.*;
public class ExpenseTrackerApp {
    public static void main(String[] args) {

        ExpenseManager expenseManager = new ExpenseManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Expense Tracker!");

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Expense");
            System.out.println("2. List Expenses");
            System.out.println("3. Total Spending");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    printCategories();
                    System.out.print("Enter category: ");
                    String categoryInput = scanner.nextLine();
                    try {
                        Category category = Category.valueOf(categoryInput.toUpperCase());
                        System.out.print("Enter description: ");
                        String description = scanner.nextLine();
                        expenseManager.addExpense(amount, category, description);
                        System.out.println("Expense added successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid category. Please try again.");
                    }
                }
                case 2 -> {
                    System.out.println("Listing all expenses:");
                    expenseManager.getExpenses().forEach(System.out::println);
                }
                case 3 -> {
                    System.out.println("Total spending: " + expenseManager.getTotalExpenses());
                }
                case 4 -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static void printCategories() {
        System.out.println("Available Categories:");
        for (Category category : Category.values()) {
            System.out.println("- " + category);
        }
    }
}