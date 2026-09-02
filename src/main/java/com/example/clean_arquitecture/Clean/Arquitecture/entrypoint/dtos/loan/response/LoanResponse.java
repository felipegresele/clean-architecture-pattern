package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.loan.response;

import com.example.clean_arquitecture.Clean.Arquitecture.core.enums.LoanStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponse {
    String memberId;
    LocalDate loanDate;
    LocalDate dueDate;
    LocalDate returnDate;
    Integer renewalCount;
    LoanStatus status;
}