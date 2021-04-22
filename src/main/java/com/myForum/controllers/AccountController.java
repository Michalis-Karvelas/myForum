package com.myForum.controllers;

import com.myForum.models.Account;
import com.myForum.requests.AccountRequest;
import com.myForum.responses.AccountResponse;
import com.myForum.responses.Response;
import com.myForum.services.AccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@Slf4j
@RestController
@RequestMapping(value = "/api/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    //returns a list of all the accounts
    @GetMapping(value = "/getall")
    public AccountResponse getAll(){
        log.info("Controller:Ready to find the accounts");
        return new AccountResponse("Found all the accounts",accountService.getAll());
    }

    //finds account by id
    @GetMapping(value ="/getbyid/{accountId}")
    public AccountResponse getById(@PathVariable(value = "accountId") Long accountId) {
        log.info("Controller: Ready to find the account with id: {}", accountId);
        return new AccountResponse("Found the account", accountService.getById(accountId));
    }

    //finds account by username
    @GetMapping(value ="/getbyusername/{username}")
    public AccountResponse getByUsername(@PathVariable(value = "username") String username) {
        log.info("Controller: Ready to find the account with username: {}", username);
        return new AccountResponse("Found the account", accountService.getByUsername(username));
    }

    //create new account
    @PostMapping(value = "/new", consumes = "application/json", produces = "application/json")
    public Response createNewAccount(@RequestBody AccountRequest request){
        log.info("Controller: Ready to create a new account");
        accountService.newAccount(request);
        log.info("The account has been saved");
        return new Response("The account has been saved");
    }

    @PutMapping(value = "/update/{accountId}",consumes = "application/json",produces = "application/json")
    public Response updateExistingAccount(@PathVariable (value = "accountId") Long accountId,
                                          @RequestBody AccountRequest request){
        log.info("Controller: Ready to update the account with id: {}", accountId);
        Account account=accountService.updateAccount(accountId,request);
        if(isNull(account)){
            return new Response("The account couldn't be updated");
        }
        return new Response("Account updated successfully");
    }
}
