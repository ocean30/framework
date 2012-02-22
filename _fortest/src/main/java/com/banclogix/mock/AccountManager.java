package com.banclogix.mock;
public interface AccountManager {

    public Account findAccountForUser(String userId);

    public void updateAccount(Account account);
}
