package org.example.entities;

public class Transaction {
    private long amount;
    private long timestamp;
    private String counterParty;
    private String type;

    public Transaction(long amount, long timestamp, String counterParty, String type) {
        this.amount = amount;
        this.timestamp = timestamp;
        this.counterParty = counterParty;
        this.type = type;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCounterParty() {
        return counterParty;
    }

    public void setCounterParty(String counterParty) {
        this.counterParty = counterParty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
