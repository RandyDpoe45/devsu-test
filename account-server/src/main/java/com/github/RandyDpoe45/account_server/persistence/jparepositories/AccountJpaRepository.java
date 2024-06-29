package com.github.RandyDpoe45.account_server.persistence.jparepositories;

import com.github.RandyDpoe45.account_server.persistence.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountJpaRepository extends JpaRepository<Account, Long> {

    List<Account> findByAccountOwnerId(Long clientId);

    Account findByNumber(String number);
}
