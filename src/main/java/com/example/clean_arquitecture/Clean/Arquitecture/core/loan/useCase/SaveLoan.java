package com.example.clean_arquitecture.Clean.Arquitecture.core.loan.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.loan.contracts.LoanRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.loan.domain.Loan;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.loan.request.LoanRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.LoanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveLoan {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    public Loan execute(LoanRequest request) {
        Loan loan = this.loanMapper.toRequestToEntity(request);
        this.loanRepository.save(loan);
        return loan;
    }

}
