package com.github.RandyDpoe45.account_server.services.implementations.account;

import com.github.RandyDpoe45.account_server.controllers.account.dtos.AccountCreationDto;
import com.github.RandyDpoe45.account_server.controllers.account.dtos.AccountUpdateDto;
import com.github.RandyDpoe45.account_server.exceptions.exceptiontypes.AccountServiceException;
import com.github.RandyDpoe45.account_server.exceptions.exceptiontypes.ExceptionCodesEnum;
import com.github.RandyDpoe45.account_server.persistence.jparepositories.AccountJpaRepository;
import com.github.RandyDpoe45.account_server.persistence.jparepositories.AccountStatusJpaRepository;
import com.github.RandyDpoe45.account_server.persistence.jparepositories.AccountTypeJpaRepository;
import com.github.RandyDpoe45.account_server.persistence.model.Account;
import com.github.RandyDpoe45.account_server.persistence.model.AccountStatus;
import com.github.RandyDpoe45.account_server.persistence.model.AccountType;
import com.github.RandyDpoe45.account_server.services.interfaces.account.AccountService;
import com.github.RandyDpoe45.account_server.services.interfaces.client.ClientService;
import com.github.RandyDpoe45.account_server.services.interfaces.client.ClientDto;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final ClientService clientService;
    private final AccountJpaRepository accountJpaRepository;
    private final AccountStatusJpaRepository accountStatusJpaRepository;
    private final AccountTypeJpaRepository accountTypeJpaRepository;
    private final EntityManager entityManager;

    @Override
    public Account getAccountById(Long accountId) {
        return accountJpaRepository.findById(accountId)
                .orElseThrow(() -> new AccountServiceException(ExceptionCodesEnum.ACCOUNT_NOT_FOUND));
    }

    @Override
    public List<Account> getAllUserAccounts(Long userId) {
        return accountJpaRepository.findByAccountOwnerId(userId);
    }

    @Override
    @Transactional
    public Account createAccount(AccountCreationDto accountDto) {
        AccountType accountType = accountTypeJpaRepository.findByCode(accountDto.accountTypeCode());
        if (Objects.isNull(accountType))
            throw new AccountServiceException(ExceptionCodesEnum.ACCOUNT_TYPE_NOT_FOUND);
        AccountStatus accountStatus = accountStatusJpaRepository.findByCode(accountDto.accountStatusCode());
        if (Objects.isNull(accountStatus))
            throw new AccountServiceException(ExceptionCodesEnum.ACCOUNT_STATUS_NOT_FOUND);
        ClientDto clientDto = clientService.getClientById(accountDto.userId());
        if(Objects.isNull(clientDto.id()))
            throw new AccountServiceException(ExceptionCodesEnum.CLIENT_NOT_FOUND);

        Account account = new Account()
                .setAccountType(accountType)
                .setAccountOwnerId(accountDto.userId())
                .setAccountStatus(accountStatus)
                .setInitialBalance(accountDto.initialBalance())
                .setNumber(createAccountNumber());

        account = accountJpaRepository.saveAndFlush(account);
        entityManager.refresh(account);
        return account;
    }

    private String createAccountNumber(){
        LocalDateTime now  = LocalDateTime.now();
        return String.format(
                "%s%02d%02d%02d",
                RandomStringUtils.randomNumeric(6),
                now.getHour(),
                now.getMinute(),
                now.getSecond()
        );
    }

    @Override
    @Transactional
    public Account updateAccount(Long id, AccountUpdateDto accountDto) {
        Account account = getAccountById(id);
        AccountType accountType = accountTypeJpaRepository.findByCode(accountDto.accountTypeCode());
        if (Objects.isNull(accountType))
            throw new AccountServiceException(ExceptionCodesEnum.ACCOUNT_TYPE_NOT_FOUND);
        AccountStatus accountStatus = accountStatusJpaRepository.findByCode(accountDto.accountStatusCode());
        if (Objects.isNull(accountStatus))
            throw new AccountServiceException(ExceptionCodesEnum.ACCOUNT_STATUS_NOT_FOUND);
        account.setAccountType(accountType)
                .setAccountStatus(accountStatus);
        account = accountJpaRepository.saveAndFlush(account);
        entityManager.refresh(account);
        return account;
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = getAccountById(id);
        accountJpaRepository.delete(account);
    }
}
