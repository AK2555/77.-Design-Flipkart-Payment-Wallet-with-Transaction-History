package org.example.strategy;

import org.example.entities.Transaction;

import java.util.List;

public interface SortingStrategy {
    void sort(List<Transaction> transactions);
}
