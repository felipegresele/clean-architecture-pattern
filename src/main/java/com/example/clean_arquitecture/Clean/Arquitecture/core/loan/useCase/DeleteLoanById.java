package com.example.clean_arquitecture.Clean.Arquitecture.core.loan.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.loan.contracts.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteLoanById {

    private final LoanRepository loanRepository;

    public void execute(String id) {
        this.loanRepository.delete(id);
    }

}
