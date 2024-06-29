package com.github.RandyDpoe45.account_server.services.interfaces.account;

import com.github.RandyDpoe45.account_server.controllers.account.dtos.AccountCreationDto;
import com.github.RandyDpoe45.account_server.controllers.account.dtos.AccountUpdateDto;
import com.github.RandyDpoe45.account_server.persistence.model.Account;

import java.util.List;

public interface AccountService {

    Account getAccountById(Long accountId);

    List<Account> getAllUserAccounts(Long userId);

    Account createAccount(AccountCreationDto account);

    Account updateAccount(Long id, AccountUpdateDto account);

    void deleteAccount(Long id);

}
