package com.example.clean_arquitecture.Clean.Arquitecture.core.loan.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.loan.contracts.LoanRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.loan.domain.Loan;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetLoanById {

    private final LoanRepository loanRepository;

    public Loan execute(String id) {
        return this.loanRepository.getLoanById(id).orElseThrow(() -> new ResourceNotFoundException("Not found loan with id " + id));
    }

}
