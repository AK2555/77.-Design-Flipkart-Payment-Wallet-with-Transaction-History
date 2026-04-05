package org.example.strategy;

import org.example.entities.Transaction;

import java.util.Collections;
import java.util.List;

public class AmountSortingStrategy implements SortingStrategy{
    @Override
    public void sort(List<Transaction> transactions) {
        Collections.sort(transactions,(a,b)-> Long.compare(b.getAmount(),a.getAmount()));
    }
}
