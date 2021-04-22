package com.myForum.services.interfaces;

import com.myForum.models.Account;
import com.myForum.requests.AccountRequest;

import java.util.List;

public interface IAccountService {

    //a list with all the accounts
    List<Account> getAll();

    //account found by the given id
    Account getById(Long accountId);

    //create a new account
    boolean newAccount(AccountRequest account);

    //update account with the given id
    Account updateAccount(Long accountId, AccountRequest account);

    Account getByUsername(String Username);
//    //delete an account with the given id
//    boolean deactivateAccount(Long accountId);
}
