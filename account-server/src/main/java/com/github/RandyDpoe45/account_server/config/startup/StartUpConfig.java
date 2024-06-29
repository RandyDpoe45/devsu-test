package com.github.RandyDpoe45.account_server.config.startup;

import com.github.RandyDpoe45.account_server.persistence.enums.AccountStatusEnum;
import com.github.RandyDpoe45.account_server.persistence.enums.AccountTypeEnum;
import com.github.RandyDpoe45.account_server.persistence.enums.MovementTypeEnum;
import com.github.RandyDpoe45.account_server.persistence.jparepositories.AccountStatusJpaRepository;
import com.github.RandyDpoe45.account_server.persistence.jparepositories.AccountTypeJpaRepository;
import com.github.RandyDpoe45.account_server.persistence.jparepositories.MovementTypeJpaRepository;
import com.github.RandyDpoe45.account_server.persistence.model.AccountStatus;
import com.github.RandyDpoe45.account_server.persistence.model.AccountType;
import com.github.RandyDpoe45.account_server.persistence.model.MovementType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StartUpConfig {

    private final AccountStatusJpaRepository accountStatusJpaRepository;

    private final AccountTypeJpaRepository accountTypeJpaRepository;

    private final MovementTypeJpaRepository movementTypeJpaRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void startUpConfig() {
        createAccountStatuses();
        createAccountTypes();
        createMovementTypes();
    }

    private void createAccountStatuses() {
        List<AccountStatus> accountStatuses = accountStatusJpaRepository.findAll();
        List<String> accountStatusNames = accountStatuses.stream().map(AccountStatus::getCode).toList();
        List<AccountStatusEnum> missingTypes = Arrays.stream(AccountStatusEnum.values())
                .filter(x -> !accountStatusNames.contains(x.getCode()))
                .toList();
        missingTypes.forEach(x -> accountStatusJpaRepository.save(new AccountStatus().setCode(x.getCode())));
    }

    private void createAccountTypes() {
        List<AccountType> currentAccountTypes = accountTypeJpaRepository.findAll();
        List<String> accountTypeCodes = currentAccountTypes.stream().map(AccountType::getCode).toList();
        List<AccountTypeEnum> missingTypes = Arrays.stream(AccountTypeEnum.values())
                .filter(x -> !accountTypeCodes.contains(x.getCode()))
                .toList();
        missingTypes.forEach(x -> accountTypeJpaRepository.save(new AccountType().setCode(x.getCode())));
    }

    private void createMovementTypes() {
        List<MovementType> currentInterestTypes = movementTypeJpaRepository.findAll();
        List<String> movementTypeCodes = currentInterestTypes.stream().map(MovementType::getCode).toList();
        List<MovementTypeEnum> missingTypes = Arrays.stream(MovementTypeEnum.values())
                .filter(x -> !movementTypeCodes.contains(x.getCode()))
                .toList();
        missingTypes.forEach(x -> movementTypeJpaRepository.save(new MovementType().setCode(x.getCode())));
    }

}
