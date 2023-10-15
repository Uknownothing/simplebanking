package com.eteration.simplebanking.model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

// This class is a place holder you can change the complete implementation
public abstract class Transaction {

    private LocalDateTime date = LocalDateTime.now();
    private final double amount;

    public Transaction(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", amount=" + amount +
                '}';
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

}
