package org.example.strategy;

import org.example.entities.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ReceiveFilterStrategy implements FilterStrategy{
    @Override
    public List<Transaction> filter(List<Transaction> transactions) {
        List<Transaction> res=new ArrayList<>();
        for(int i=0;i<transactions.size();i++){
            Transaction transaction=transactions.get(i);
            if(transaction.getType().equals("RECEIVE")){
                res.add(transaction);
            }
        }
        return res;
    }
}
