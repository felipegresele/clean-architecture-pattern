package com.example.clean_arquitecture.Clean.Arquitecture.core.loan.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.loan.contracts.LoanRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.loan.domain.Loan;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.loan.request.LoanRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.exceptions.ResourceNotFoundException;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.LoanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateLoan {

    private final LoanRepository loanRepository;

    public Loan execute(String id, LoanRequest loanRequest) {
        Loan loan = this.loanRepository.getLoanById(id).orElseThrow(() -> new ResourceNotFoundException("Not found loan with id " + id));
        LoanMapper.updateLoan(loan, loanRequest);

        return loanRepository.save(loan);
    }

}
