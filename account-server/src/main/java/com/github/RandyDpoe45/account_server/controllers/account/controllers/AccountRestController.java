package com.github.RandyDpoe45.account_server.controllers.account.controllers;

import com.github.RandyDpoe45.account_server.controllers.account.dtos.AccountCreationDto;
import com.github.RandyDpoe45.account_server.controllers.account.dtos.AccountUpdateDto;
import com.github.RandyDpoe45.account_server.persistence.model.Account;
import com.github.RandyDpoe45.account_server.services.interfaces.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable("id") Long id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/user/{id}")
    public List<Account> getAccountByUserId(@PathVariable("id") Long id) {
        return accountService.getAllUserAccounts(id);
    }

    @PostMapping
    public Account createAccount(@RequestBody AccountCreationDto account) {
        return accountService.createAccount(account);
    }

    @PatchMapping("/{id}")
    public Account updateAccount(
            @PathVariable Long id,
            @RequestBody AccountUpdateDto account
    ) {
        return accountService.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}
