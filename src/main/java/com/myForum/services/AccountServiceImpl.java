package com.myForum.services;

import com.myForum.models.Account;
import com.myForum.models.AccountStatus;
import com.myForum.models.Role;
import com.myForum.repositories.AccountRepository;
import com.myForum.repositories.AccountStatusRepository;
import com.myForum.repositories.RoleRepository;
import com.myForum.requests.AccountRequest;
import com.myForum.services.interfaces.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;


@Service
@Slf4j
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AccountStatusRepository accountStatusRepository;

    @Override
    public List<Account> getAll() {
        log.info("Ready to find all the accounts");
        return accountRepository.findAll();
    }

    @Override
    public Account getById(Long accountId) {
        log.info("Ready to find the account with id: {}", accountId );
        return accountRepository.findById(accountId).orElse(null);
    }

    @Override
    public boolean newAccount(AccountRequest request) {
        log.info("Ready to create a new account");
        Role role=roleRepository.findById(2L).orElse(null);
        AccountStatus accountStatus=accountStatusRepository.findById(1L).orElse(null);
        Account tempAccount= new Account(request.getUsername(),request.getPassword(), request.getEmail(),
                request.getDateOfBirth(),role,accountStatus);
        Account newAccount=accountRepository.save(tempAccount);
        log.info("The new account is: {}",newAccount);
        log.info("The account has been inserted in the DB");
        return true;
    }

    @Override
    public Account updateAccount(Long accountId, AccountRequest request) {
        log.info("Ready to update the account with id : {}", accountId);
        Account existingAccount=accountRepository.findById(accountId).orElse(null);
        if (isNull(existingAccount)){
            return null;
        }
        if(!isNull(request.getAccountStatusId())){
        existingAccount.setAccountStatus(accountStatusRepository.findById(request.getAccountStatusId()).orElse(null));
        }
        if(!isNull(request.getRoleId())){
        existingAccount.setRole(roleRepository.findById(request.getRoleId()).orElse(null));
        }
        existingAccount.setEmail(request.getEmail());
        existingAccount.setPassword(request.getPassword());
        existingAccount.setUsername(request.getUsername());
        existingAccount.setDateOfBirth(request.getDateOfBirth());
        Account updatedAccount=accountRepository.save(existingAccount);
        log.info("The updated account is: {}", updatedAccount);
        log.info("The updated account has been inserted into the DB");
        return updatedAccount;
    }

    @Override
    public Account getByUsername(String username) {
        log.info("Ready to find the account with the username: {}",username);
        return accountRepository.findByUsername(username);
    }


}
