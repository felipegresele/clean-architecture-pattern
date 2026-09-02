package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.fine.response;

import com.example.clean_arquitecture.Clean.Arquitecture.core.enums.FineStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FineResponse {
    String loanId;
    String memberId;
    BigDecimal amount;
    LocalDate generatedDate;
    LocalDate paidDate;
    FineStatus status;
}
