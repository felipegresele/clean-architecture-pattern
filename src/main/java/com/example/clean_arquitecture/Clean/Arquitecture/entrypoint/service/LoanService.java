package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.service;

import com.example.clean_arquitecture.Clean.Arquitecture.core.loan.domain.Loan;
import com.example.clean_arquitecture.Clean.Arquitecture.core.loan.useCase.*;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.loan.request.LoanRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.loan.response.LoanResponse;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.LoanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    //Use Case
    private final SaveLoan saveLoan;
    private final GetListLoans getListLoans;
    private final GetLoanById getLoanById;
    private final DeleteLoanById deleteLoanById;
    private final UpdateLoan updateLoan;

    public ResponseEntity<LoanResponse> saveLoan(LoanRequest request) {
        Loan loan = this.saveLoan.execute(request);
        return new ResponseEntity<>(LoanMapper.toEntityToResponse(loan), HttpStatus.CREATED);
    }

    public ResponseEntity<List<LoanResponse>> getAllLoans() {
        List<Loan> loans = this.getListLoans.execute();
        return new ResponseEntity<>(LoanMapper.toListLoanResponse(loans), HttpStatus.OK);
    }

    public ResponseEntity<LoanResponse> getLoanById(String id) {
        Loan loan = this.getLoanById.execute(id);
        return new ResponseEntity<>(LoanMapper.toEntityToResponse(loan), HttpStatus.OK);
    }

    public ResponseEntity<LoanResponse> updateLoanById(String id, LoanRequest request) {
        Loan loan = this.updateLoan.execute(id, request);
        return new ResponseEntity<>(LoanMapper.toEntityToResponse(loan), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteLoanById(String id) {
        this.deleteLoanById.execute(id);
        return new ResponseEntity<>("Loan with Id " + id + " deleted", HttpStatus.OK);
    }
}
