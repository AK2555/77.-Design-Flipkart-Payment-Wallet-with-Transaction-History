package org.example;

import org.example.manager.UserManager;
import org.example.manager.WalletManager;

import java.util.ArrayList;
import java.util.List;

public class FlipkartWallet {

    private WalletManager walletManager;

    public FlipkartWallet(List<String> registeredUserIds) {

    this.walletManager=new WalletManager(new UserManager());
        for(String uid: registeredUserIds){
            walletManager.addUser(uid);
        }
    }

    public boolean loadMoney(String userId, long amount, String source, long timestamp) {
       return walletManager.loadMoney(userId,amount,source,timestamp);
    }

    public boolean sendMoney(String fromUserId, String toUserId, long amount, long timestamp) {
        return walletManager.sendMoney(fromUserId,toUserId,amount,timestamp);
    }

    public long getBalance(String userId) {
        return walletManager.getBalance(userId);
    }

    public List<String> getTransactionHistory(String userId, String sortBy, String filterBy) {
        return walletManager.getTransactionHistory(userId,sortBy,filterBy);
    }
}