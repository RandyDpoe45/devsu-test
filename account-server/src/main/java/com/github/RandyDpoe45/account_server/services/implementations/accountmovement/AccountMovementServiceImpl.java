package com.github.RandyDpoe45.account_server.services.implementations.accountmovement;

import com.github.RandyDpoe45.account_server.controllers.movements.dtos.MovementCreationDto;
import com.github.RandyDpoe45.account_server.exceptions.exceptiontypes.AccountServiceException;
import com.github.RandyDpoe45.account_server.exceptions.exceptiontypes.ExceptionCodesEnum;
import com.github.RandyDpoe45.account_server.persistence.enums.MovementTypeEnum;
import com.github.RandyDpoe45.account_server.persistence.jparepositories.AccountJpaRepository;
import com.github.RandyDpoe45.account_server.persistence.jparepositories.AccountMovementJpaRepository;
import com.github.RandyDpoe45.account_server.persistence.jparepositories.MovementTypeJpaRepository;
import com.github.RandyDpoe45.account_server.persistence.model.Account;
import com.github.RandyDpoe45.account_server.persistence.model.AccountMovement;
import com.github.RandyDpoe45.account_server.persistence.model.MovementType;
import com.github.RandyDpoe45.account_server.services.interfaces.accountmovement.AccountMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountMovementServiceImpl implements AccountMovementService {

    private final AccountMovementJpaRepository accountMovementJpaRepository;
    private final MovementTypeJpaRepository movementTypeJpaRepository;
    private final AccountJpaRepository accountJpaRepository;

    @Override
    public List<AccountMovement> findByAccountNumber(String accountNumber) {
        return accountMovementJpaRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public AccountMovement findById(Long id) {
        return accountMovementJpaRepository.findById(id)
                .orElseThrow(() -> new AccountServiceException(ExceptionCodesEnum.MOVEMENT_NOT_FOUND));
    }

    @Override
    public AccountMovement save(MovementCreationDto movementCreationDto) {
        Account account = accountJpaRepository.findByNumber(movementCreationDto.accountNumber());
        if (Objects.isNull(account))
            throw new AccountServiceException(ExceptionCodesEnum.ACCOUNT_NOT_FOUND);
        MovementType movementType = movementCreationDto.amount().signum() < 0 ?
                movementTypeJpaRepository.findByCode(MovementTypeEnum.WITHDRAWAL.getCode())
                : movementTypeJpaRepository.findByCode(MovementTypeEnum.DEPOSIT.getCode());
        AccountMovement lastMovement = accountMovementJpaRepository.findFirstByOrderByMovementDateDesc();
        BigDecimal newBalance = Objects.isNull(lastMovement) ?
                account.getInitialBalance().add(movementCreationDto.amount()) :
                lastMovement.getBalance().add(movementCreationDto.amount());
        if (newBalance.compareTo(BigDecimal.ZERO) < 0)
            throw new AccountServiceException(ExceptionCodesEnum.INSUFFICIENT_FUNDS);
        AccountMovement accountMovement = new AccountMovement()
                .setAccount(account)
                .setMovementType(movementType)
                .setAmount(movementCreationDto.amount())
                .setBalance(newBalance);
        return accountMovementJpaRepository.saveAndFlush(accountMovement);
    }

    @Override
    public AccountMovement update(Long id, MovementCreationDto movementCreationDto) {
        AccountMovement accountMovement = findById(id);
        Account account = accountJpaRepository.findByNumber(movementCreationDto.accountNumber());
        if (Objects.isNull(account))
            throw new AccountServiceException(ExceptionCodesEnum.ACCOUNT_NOT_FOUND);
        MovementType movementType = movementCreationDto.amount().signum() < 0 ?
                movementTypeJpaRepository.findByCode(MovementTypeEnum.WITHDRAWAL.getCode())
                : movementTypeJpaRepository.findByCode(MovementTypeEnum.DEPOSIT.getCode());
        AccountMovement lastMovement = accountMovementJpaRepository.findFirstByOrderByMovementDateDesc();
        BigDecimal newBalance = Objects.isNull(lastMovement) ?
                account.getInitialBalance().add(movementCreationDto.amount()) :
                lastMovement.getBalance().add(movementCreationDto.amount());
        if (newBalance.compareTo(BigDecimal.ZERO) < 0)
            throw new AccountServiceException(ExceptionCodesEnum.INSUFFICIENT_FUNDS);
       accountMovement.setMovementType(movementType)
                .setAmount(movementCreationDto.amount())
                .setBalance(newBalance);
        return accountMovementJpaRepository.saveAndFlush(accountMovement);
    }

    @Override
    public void deleteById(Long id) {
        accountMovementJpaRepository.deleteById(id);
    }

    @Override
    public List<AccountMovement> findByDateBetweenAndAccountNumber(LocalDateTime from, LocalDateTime to, Long accountOwnerId) {
        return accountMovementJpaRepository.findByMovementDateBetweenAndAccountAccountOwnerId(from, to, accountOwnerId);
    }
}
