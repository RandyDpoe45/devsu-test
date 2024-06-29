package com.github.RandyDpoe45.account_server.services.implementations.report;

import com.github.RandyDpoe45.account_server.persistence.model.AccountMovement;
import com.github.RandyDpoe45.account_server.services.interfaces.accountmovement.AccountMovementService;
import com.github.RandyDpoe45.account_server.services.interfaces.client.ClientDto;
import com.github.RandyDpoe45.account_server.services.interfaces.client.ClientService;
import com.github.RandyDpoe45.account_server.services.interfaces.report.ReportMovement;
import com.github.RandyDpoe45.account_server.services.interfaces.report.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ClientService clientService;

    private final AccountMovementService accountMovementService;

    @Override
    public List<ReportMovement> createReport(LocalDateTime from, LocalDateTime to, Long userId) {
        ClientDto clientDto = clientService.getClientById(userId);
        List<AccountMovement> movements = accountMovementService.findByDateBetweenAndAccountNumber(from, to, userId);
        return movements.stream()
                .map(x -> new ReportMovement(
                        clientDto.firstName(),
                        x.getAccount().getNumber(),
                        x.getMovementType().getCode(),
                        x.getAccount().getInitialBalance(),
                        x.getAccount().getAccountStatus().getCode(),
                        x.getAmount(),
                        x.getBalance(),
                        x.getMovementDate()
                )).toList();
    }
}
