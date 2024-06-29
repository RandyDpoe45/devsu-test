package com.github.RandyDpoe45.account_server.services.interfaces.report;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReportMovement {

    String clientName;

    String accountNumber;

    String movementType;

    BigDecimal initialBalance;

    String accountStatus;

    BigDecimal amount;

    BigDecimal currentBalance;

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDateTime movementDate;
}

