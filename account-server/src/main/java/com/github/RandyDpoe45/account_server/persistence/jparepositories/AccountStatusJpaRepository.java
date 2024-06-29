package com.github.RandyDpoe45.account_server.persistence.jparepositories;

import com.github.RandyDpoe45.account_server.persistence.model.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountStatusJpaRepository extends JpaRepository<AccountStatus, Long> {

    AccountStatus findByCode(String code);
}
