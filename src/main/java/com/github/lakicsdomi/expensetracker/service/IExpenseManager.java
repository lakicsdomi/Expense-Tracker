package com.github.lakicsdomi.expensetracker.service;

import com.github.lakicsdomi.expensetracker.model.Expense;

import java.time.LocalDate;
import java.util.List;

public interface IExpenseManager {
    void addExpense(Expense expense);
    void deleteExpense(int id);
    double calculateTotalByCategory(String category);
    Expense getExpenseById(int id);
    Expense getExpenseByCategory(String category);
    List<Expense> getExpenses();
    List<Expense> getExpensesByCategory(String category);
    List<Expense> getExpensesByCategoryAndDate(String category, LocalDate date);
    List<Expense> getExpensesByDateRange(LocalDate start, LocalDate end);

}
