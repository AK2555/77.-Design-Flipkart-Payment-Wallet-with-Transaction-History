package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private long balance;
    private List<Transaction> transactions;

    public Wallet(){
        this.balance=0L;
        this.transactions=new ArrayList<>();
    }

    public void setBalance(long balance){
        this.balance=balance;
    }

    public long getBalance(){
        return balance;
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }

}
