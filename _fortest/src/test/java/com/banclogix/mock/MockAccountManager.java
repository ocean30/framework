package com.banclogix.mock;

import java.util.Hashtable;

public class MockAccountManager implements AccountManager {
    
    private Hashtable<String, Account> accounts = new Hashtable<String, Account>();

    public void addAccount(String userId, Account account) {
        this.accounts.put(userId, account);
    }

    public Account findAccountForUser(String userId) {
        return (Account) this.accounts.get(userId);
    }

    public void updateAccount(Account account) {
        // do nothing
    }
}
