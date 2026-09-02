package com.example.clean_arquitecture.Clean.Arquitecture.core.fine.domain;

import com.example.clean_arquitecture.Clean.Arquitecture.core.enums.FineStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fine {

    String loanId;
    String memberId;
    BigDecimal amount;
    LocalDate generatedDate;
    LocalDate paidDate = null;
    FineStatus status = FineStatus.PENDING;
}
