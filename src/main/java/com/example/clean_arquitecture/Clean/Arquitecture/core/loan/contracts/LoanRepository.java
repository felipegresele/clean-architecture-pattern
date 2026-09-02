package com.example.clean_arquitecture.Clean.Arquitecture.core.loan.contracts;

import com.example.clean_arquitecture.Clean.Arquitecture.core.loan.domain.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanRepository {
    Loan save(Loan loan);

    Optional<Loan> getLoanById(String id);

    List<Loan> getAllLoans();

    void delete(String id);
}
