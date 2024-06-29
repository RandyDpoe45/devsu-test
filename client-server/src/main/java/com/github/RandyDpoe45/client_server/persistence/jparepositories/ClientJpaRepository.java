package com.github.RandyDpoe45.client_server.persistence.jparepositories;

import com.github.RandyDpoe45.client_server.persistence.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientJpaRepository extends JpaRepository<Client, Long> {
}
