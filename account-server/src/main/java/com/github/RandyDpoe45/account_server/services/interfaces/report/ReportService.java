package com.github.RandyDpoe45.account_server.services.interfaces.report;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportService {

    List<ReportMovement> createReport(LocalDateTime from, LocalDateTime to, Long userId);

}
