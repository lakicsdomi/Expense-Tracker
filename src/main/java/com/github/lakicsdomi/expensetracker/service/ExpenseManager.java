package com.github.lakicsdomi.expensetracker.service;

import com.github.lakicsdomi.expensetracker.model.Category;
import com.github.lakicsdomi.expensetracker.model.Expense;
import jdk.jshell.spi.ExecutionControl;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ExpenseManager implements IExpenseManager{
    private List<Expense> expenses = new ArrayList<>();

    @Override
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    @Override
    public void addExpense(double amount, Category category, String description){
        Expense expense = new Expense(expenses.size(), LocalDate.now(), amount,category, description);
        expenses.add(expense);
    }

    @Override
    public List<Expense> getExpenses() {
        return expenses;
    }

    @Override
    public double getTotalExpenses() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    @Override
    public void deleteExpense(int id) {
        expenses.removeIf(expense -> expense.getId() == id);
    }

    @Override
    public double calculateTotalByCategory(Category category){
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    @Override
    public Expense getExpenseById(int id){
        return expenses.stream().filter(expense -> expense.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Expense getExpenseByCategory(Category category){
        return expenses.stream().filter(expense -> expense.getCategory() == category).findFirst().orElse(null);
    }

    @Override
    public List<Expense> getExpensesByCategory(Category category){
        return expenses.stream().filter(expense -> expense.getCategory() == category).toList();
    }

    @Override
    public List<Expense> getExpensesByCategoryAndDate(Category category, LocalDate date) {
        return expenses.stream().filter(expense -> expense.getCategory() == category && expense.getDate().equals(date)).toList();
    }

    @Override
    public List<Expense> getExpensesByDateRange(LocalDate start, LocalDate end){
        return expenses.stream().filter(expense -> expense.getDate().equals(start) && expense.getDate().equals(end)).toList();
    }
}
