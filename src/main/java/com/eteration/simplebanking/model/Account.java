package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


public class Account {

    private  String owner;
    private  String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public Account(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        transactions = new ArrayList<>();
    }

    public void deposit(double amount){
        setBalance(getBalance()+amount);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        //Para cekme islemi icin cekilecek miktarın balance'a göre olan durumunun kontrolu
        if (balance<amount){
            throw new InsufficientBalanceException("Balance can not be less than amount");
        }
        setBalance(getBalance()-amount);

    }

    public String getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public boolean post(Transaction transaction) throws InsufficientBalanceException {
        if(transaction instanceof WithdrawalTransaction){
            withdraw(transaction.getAmount());
        }
        if(transaction instanceof DepositTransaction){
            deposit(transaction.getAmount());
        }
        return transactions.add(transaction);
    }

    public boolean credit(double amount) throws InsufficientBalanceException {
        //Para cekme islemi icin cekilecek miktarın balance'a göre olan durumunun kontrolu
        if (balance<amount){
            throw new InsufficientBalanceException("Balance can not be less than amount");
        }
        setBalance(getBalance()-amount);
        return transactions.add(new DepositTransaction(amount));

    }

    public boolean debit(double amount){
        setBalance(getBalance()+amount);
        return transactions.add(new DepositTransaction(amount));
    }
}

