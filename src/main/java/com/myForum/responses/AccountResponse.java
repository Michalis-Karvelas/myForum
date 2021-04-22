package com.myForum.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.myForum.models.Account;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponse extends Response{

    private Account account;
    private List<Account> accounts;
    private Long accountId;
//    private Long roleId;

    public AccountResponse(String msg, Account account) {
        super(msg);
        this.account = account;
    }

    public AccountResponse(String msg, List<Account> accounts) {
        super(msg);
        this.accounts = accounts;
    }

    public AccountResponse(String msg, Long accountId) {
        super(msg);
        this.accountId = accountId;
    }
}
