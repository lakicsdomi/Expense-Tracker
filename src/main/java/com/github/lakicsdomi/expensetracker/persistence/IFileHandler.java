package com.github.lakicsdomi.expensetracker.persistence;

import com.github.lakicsdomi.expensetracker.model.Expense;

import java.io.IOException;
import java.util.List;

public interface IFileHandler {
    void saveExpensesToFile(List<Expense> expenses, String filePath) throws IOException;
    List<Expense> loadExpensesFromFile(String filePath) throws IOException, ClassNotFoundException;
}
