package org.example;

import java.util.List;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        FlipkartWallet wallet = new FlipkartWallet(
                List.of("user-0", "user-1", "user-2")
        );

        // Invalid user checks
        System.out.println(wallet.getBalance("ghost")); // -1
        System.out.println(wallet.getTransactionHistory("ghost", "time", "all")); // []

        // Initial state
        System.out.println(wallet.getBalance("user-0")); // 0
        System.out.println(wallet.getTransactionHistory("user-0", "time", "all")); // []

        // Invalid load cases
        System.out.println(wallet.loadMoney("user-0", 0, "UPI", 1100)); // false
        System.out.println(wallet.loadMoney("user-0", 10, "UPI", 0)); // false
        System.out.println(wallet.loadMoney("ghost", 10, "UPI", 1100)); // false

        // Valid loads
        System.out.println(wallet.loadMoney("user-0", 503, "UPI", 1101)); // true
        System.out.println(wallet.loadMoney("user-1", 302, "CreditCard", 1102)); // true

        // Invalid send cases
        System.out.println(wallet.sendMoney("user-2", "user-0", 1, 1103)); // false
        System.out.println(wallet.sendMoney("user-0", "user-1", 0, 1104)); // false
        System.out.println(wallet.sendMoney("user-0", "ghost", 10, 1105)); // false
        System.out.println(wallet.sendMoney("user-0", "user-1", 10, 0)); // false

        // Valid sends
        System.out.println(wallet.sendMoney("user-0", "user-2", 201, 1106)); // true
        System.out.println(wallet.sendMoney("user-1", "user-0", 101, 1107)); // true

        // Balances
        System.out.println(wallet.getBalance("user-0")); // 403
        System.out.println(wallet.getBalance("user-1")); // 201
        System.out.println(wallet.getBalance("user-2")); // 201

        // History (time, all)
        System.out.println("\nuser-0 history (time, all):");
        for (String txn : wallet.getTransactionHistory("user-0", "time", "all")) {
            System.out.println(txn);
        }

        // History (amount, all)
        System.out.println("\nuser-0 history (amount, all):");
        for (String txn : wallet.getTransactionHistory("user-0", "amount", "all")) {
            System.out.println(txn);
        }

        // History (time, send)
        System.out.println("\nuser-0 history (time, send):");
        for (String txn : wallet.getTransactionHistory("user-0", "time", "send")) {
            System.out.println(txn);
        }
    }
}

