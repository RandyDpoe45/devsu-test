package com.github.RandyDpoe45.account_server.services.interfaces.accountmovement;

import com.github.RandyDpoe45.account_server.controllers.movements.dtos.MovementCreationDto;
import com.github.RandyDpoe45.account_server.persistence.model.AccountMovement;

import java.time.LocalDateTime;
import java.util.List;

public interface AccountMovementService {

    List<AccountMovement> findByAccountNumber(String accountNumber);
    AccountMovement findById(Long id);
    AccountMovement save(MovementCreationDto movementCreationDto);
    AccountMovement update(Long id, MovementCreationDto movementCreationDto);
    void deleteById(Long id);
    List<AccountMovement> findByDateBetweenAndAccountNumber(LocalDateTime from, LocalDateTime to, Long accountOwnerId);

}
