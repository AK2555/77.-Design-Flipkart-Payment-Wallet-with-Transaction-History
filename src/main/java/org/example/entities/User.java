package org.example.entities;

public class User {
    private final String userId;
    private Wallet wallet;

    public User(String userId, Wallet wallet) {
        this.userId = userId;
        this.wallet = wallet;
    }

    public String getUserId() {
        return userId;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
