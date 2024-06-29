package com.github.RandyDpoe45.account_server.controllers.movements.controllers;

import com.github.RandyDpoe45.account_server.controllers.movements.dtos.MovementCreationDto;
import com.github.RandyDpoe45.account_server.persistence.model.AccountMovement;
import com.github.RandyDpoe45.account_server.services.interfaces.accountmovement.AccountMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("accountMovement")
@RequiredArgsConstructor
public class AccountMovementRestController {
    
    private final AccountMovementService accountMovementService;

    @GetMapping("/{id}")
    public AccountMovement getAccountMovementById(@PathVariable("id") Long id) {
        return accountMovementService.findById(id);
    }


    @PostMapping
    public AccountMovement createAccountMovement(@RequestBody MovementCreationDto movement) {
        return accountMovementService.save(movement);
    }

    @PatchMapping("/{id}")
    public AccountMovement updateAccountMovement(
            @PathVariable Long id,
            @RequestBody MovementCreationDto modificationDto
    ) {
        return accountMovementService.update(id, modificationDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAccountMovement(@PathVariable Long id) {
        accountMovementService.deleteById(id);
    }

}
