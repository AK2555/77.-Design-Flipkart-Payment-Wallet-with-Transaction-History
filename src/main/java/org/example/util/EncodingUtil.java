package org.example.util;

import org.example.entities.Transaction;

public class EncodingUtil {
    public static String encode(Transaction transaction){
        return "time="+transaction.getTimestamp()+"|type="+transaction.getType()+"|counterparty="+transaction.getCounterParty()+"|amount="+transaction.getAmount();
    }
}
