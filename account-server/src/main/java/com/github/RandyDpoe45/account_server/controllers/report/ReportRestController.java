package com.github.RandyDpoe45.account_server.controllers.report;

import com.github.RandyDpoe45.account_server.services.interfaces.report.ReportMovement;
import com.github.RandyDpoe45.account_server.services.interfaces.report.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("report")
@RequiredArgsConstructor
public class ReportRestController {

    private final ReportService reportService;

    @GetMapping
    public List<ReportMovement> getAccountMovementReport(
            @RequestParam(name = "desde") String from,
            @RequestParam(name = "hasta") String to,
            @RequestParam(name = "idCliente") Long accountOwnerID
    ) {
        System.out.println(from);
        System.out.println(to);
        LocalDateTime fromDate = LocalDate.parse(from, DateTimeFormatter.ofPattern("dd/MM/yyyy")).atStartOfDay();
        LocalDateTime toDate = LocalDate.parse(to, DateTimeFormatter.ofPattern("dd/MM/yyyy")).plusDays(1).atStartOfDay();
        return reportService.createReport(fromDate, toDate, accountOwnerID);
    }
}
