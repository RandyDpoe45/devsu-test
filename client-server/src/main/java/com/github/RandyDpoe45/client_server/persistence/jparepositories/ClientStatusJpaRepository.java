package com.github.RandyDpoe45.client_server.persistence.jparepositories;

import com.github.RandyDpoe45.client_server.persistence.model.ClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientStatusJpaRepository extends JpaRepository<ClientStatus, Long> {
    ClientStatus findByCode(String code);
}
