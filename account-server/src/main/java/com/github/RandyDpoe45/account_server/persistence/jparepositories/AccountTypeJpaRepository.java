package com.github.RandyDpoe45.account_server.persistence.jparepositories;

import com.github.RandyDpoe45.account_server.persistence.model.Account;
import com.github.RandyDpoe45.account_server.persistence.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeJpaRepository extends JpaRepository<AccountType, Long> {
    AccountType findByCode(String code);
}
