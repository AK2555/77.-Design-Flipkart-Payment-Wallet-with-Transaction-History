package org.example.strategy;

import org.example.entities.Transaction;

import java.util.Collections;
import java.util.List;

public class TimeSortingStrategy implements SortingStrategy{
    @Override
    public void sort(List<Transaction> transactions) {
        Collections.sort(transactions,(a,b)-> Long.compare(a.getTimestamp(),b.getTimestamp()));
    }
}
