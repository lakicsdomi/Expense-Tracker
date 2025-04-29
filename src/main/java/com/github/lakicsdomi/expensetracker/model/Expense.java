package com.github.lakicsdomi.expensetracker.model;

import java.time.LocalDate;

public class Expense {
    private final int id;
    private LocalDate date;
    private double amount;
    private Category category;
    private String description;

    public Expense(int id, LocalDate date, double amount, Category category, String description) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate(){
        return date;
    }

    public double getAmount(){
        return amount;
    }

    public Category getCategory(){
        return category;
    }

    public String getDescription(){
        return description;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String toString(){
        return String.format("Expense [ID: %d, Date: %s, Category: %s, Description: %s, Amount: %.2f]",
                id, date, category, description, amount);
    }

}
