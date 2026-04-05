package org.example.manager;

import org.example.entities.User;
import org.example.entities.Wallet;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> userMap;

    public UserManager(){
        this.userMap=new HashMap<>();
    }

    public boolean isUserPresent(String userId){
        return userMap.containsKey(userId);
    }

    public void addUser(String userId,Wallet wallet){
        User user=new User(userId,wallet);
        userMap.put(userId,user);
    }

    public User getUser(String userId){
        if(!isUserPresent(userId)){
            return null;
        }
        return userMap.get(userId);
    }
}
