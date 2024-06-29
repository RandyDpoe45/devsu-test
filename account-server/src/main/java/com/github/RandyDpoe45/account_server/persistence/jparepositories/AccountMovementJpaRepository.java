package com.github.RandyDpoe45.account_server.persistence.jparepositories;

import com.github.RandyDpoe45.account_server.persistence.model.AccountMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AccountMovementJpaRepository extends JpaRepository<AccountMovement, Long> {

    List<AccountMovement> findByAccountNumber(String accountNumber);
    AccountMovement findFirstByOrderByMovementDateDesc();
    List<AccountMovement> findByMovementDateBetweenAndAccountAccountOwnerId(LocalDateTime from, LocalDateTime to, Long accountOwnerId);
}
