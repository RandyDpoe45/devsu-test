package com.github.RandyDpoe45.account_server.persistence.jparepositories;

import com.github.RandyDpoe45.account_server.persistence.model.MovementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementTypeJpaRepository extends JpaRepository<MovementType, Long> {
    MovementType findByCode(String code);
}
