package org.example.strategy;

import org.example.entities.Transaction;

import java.util.List;

public interface FilterStrategy {
    List<Transaction> filter(List<Transaction> transactions);
}
