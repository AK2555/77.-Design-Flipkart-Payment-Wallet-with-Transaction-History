package org.example.manager;

import org.example.entities.Transaction;
import org.example.entities.User;
import org.example.entities.Wallet;
import org.example.strategy.*;
import org.example.util.EncodingUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WalletManager {
    private UserManager userManager;
    private Map<String, FilterStrategy> filterStrategyMap;
    private Map<String, SortingStrategy> sortingStrategyMap;
    public WalletManager(UserManager userManager){
        this.userManager=userManager;
        this.filterStrategyMap=new HashMap<>();
        filterStrategyMap.put("send",new SendFilterStrategy());
        filterStrategyMap.put("receive",new ReceiveFilterStrategy());
        filterStrategyMap.put("all",new AllFilterStrategy());

        this.sortingStrategyMap=new HashMap<>();
        sortingStrategyMap.put("amount",new AmountSortingStrategy());
        sortingStrategyMap.put("time",new TimeSortingStrategy());
    }

    public void addUser(String userId){
        Wallet wallet=new Wallet();
        if(userManager.isUserPresent(userId)){
            return;
        }
        userManager.addUser(userId,wallet);
    }

    public boolean loadMoney(String userId, long amount, String source, long timestamp){
        if(!userManager.isUserPresent(userId) || amount<=0 || timestamp<=0){
            return false;
        }
        User user=userManager.getUser(userId);
        Transaction transaction=new Transaction(amount,timestamp,source,"LOAD");
        Wallet wallet=user.getWallet();
        wallet.setBalance(wallet.getBalance()+amount);
        wallet.addTransaction(transaction);
        return true;
    }

    public boolean sendMoney(String fromUserId, String toUserId, long amount, long timestamp) {
        if(!userManager.isUserPresent(fromUserId) || !userManager.isUserPresent(toUserId) || amount<=0 || timestamp<=0){
            return false;
        }

        User sender=userManager.getUser(fromUserId);
        Wallet fromWallet=sender.getWallet();
        if(fromWallet.getBalance()<amount){
            return false;
        }
        User receiver=userManager.getUser(toUserId);
        Wallet toWallet=receiver.getWallet();

        fromWallet.setBalance(fromWallet.getBalance()-amount);
        toWallet.setBalance(toWallet.getBalance()+amount);

        Transaction txn1=new Transaction(amount,timestamp,toUserId,"SEND");
        Transaction txn2=new Transaction(amount,timestamp,fromUserId,"RECEIVE");

        fromWallet.addTransaction(txn1);
        toWallet.addTransaction(txn2);

        return true;
    }

    public long getBalance(String userId) {
        if(!userManager.isUserPresent(userId)){
            return -1;
        }
        return userManager.getUser(userId).getWallet().getBalance();
    }

    public List<String> getTransactionHistory(String userId, String sortBy, String filterBy) {
        if(!userManager.isUserPresent(userId)){
            return new ArrayList<>();
        }
        User user=userManager.getUser(userId);
        Wallet wallet=user.getWallet();
        List<Transaction> txns=wallet.getTransactions();

        List<Transaction> filterTxn= filterStrategyMap.get(filterBy).filter(txns);

        sortingStrategyMap.get(sortBy).sort(filterTxn);

        List<String> res=new ArrayList<>();

        for(Transaction transaction: filterTxn){
            res.add(EncodingUtil.encode(transaction));
        }

        return res;
    }


}
