package com.example.clean_arquitecture.Clean.Arquitecture.core.loan.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.loan.contracts.LoanRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.loan.domain.Loan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetListLoans {

    private final LoanRepository loanRepository;

    public List<Loan> execute() {
        return this.loanRepository.getAllLoans();
    }

}
