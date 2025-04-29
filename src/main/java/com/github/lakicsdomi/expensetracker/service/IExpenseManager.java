package com.github.lakicsdomi.expensetracker.service;

import com.github.lakicsdomi.expensetracker.model.Category;
import com.github.lakicsdomi.expensetracker.model.Expense;

import java.time.LocalDate;
import java.util.List;

public interface IExpenseManager {
    void addExpense(Expense expense);
    void addExpense(double amount, Category category, String description);
    void deleteExpense(int id);
    double calculateTotalByCategory(Category category);
    Expense getExpenseById(int id);
    Expense getExpenseByCategory(Category category);
    List<Expense> getExpenses();
    List<Expense> getExpensesByCategory(Category category);
    List<Expense> getExpensesByCategoryAndDate(Category category, LocalDate date);
    List<Expense> getExpensesByDateRange(LocalDate start, LocalDate end);
    double getTotalExpenses();
}
