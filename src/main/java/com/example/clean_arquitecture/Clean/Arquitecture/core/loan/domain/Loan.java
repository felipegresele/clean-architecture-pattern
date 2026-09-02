package com.example.clean_arquitecture.Clean.Arquitecture.core.loan.domain;

import com.example.clean_arquitecture.Clean.Arquitecture.core.enums.LoanStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {

    String memberId;
    LocalDate loanDate;
    LocalDate dueDate;
    LocalDate returnDate;
    Integer renewalCount;
    LoanStatus status;
}
