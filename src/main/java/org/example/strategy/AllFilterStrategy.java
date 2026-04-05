package org.example.strategy;

import org.example.entities.Transaction;

import java.util.List;

public class AllFilterStrategy implements FilterStrategy{
    @Override
    public List<Transaction> filter(List<Transaction> transactions) {
        return transactions;
    }
}
