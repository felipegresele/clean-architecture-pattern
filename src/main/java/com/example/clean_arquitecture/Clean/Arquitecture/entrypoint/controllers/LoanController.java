package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.controllers;

import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.loan.request.LoanRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.loan.response.LoanResponse;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loan")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<LoanResponse>> getAllLoans() {
        return this.loanService.getAllLoans();
    }

    @PostMapping("/save")
    public ResponseEntity<LoanResponse> save(@RequestBody LoanRequest request) {
        return this.loanService.saveLoan(request);
    }

    @GetMapping("/get-loan/{id}")
    public ResponseEntity<LoanResponse> findLoanById(
            @PathVariable String id) {
        return this.loanService.getLoanById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LoanResponse> updateLoan(
            @PathVariable String id,
            @RequestBody LoanRequest loanRequest) {
        return this.loanService.updateLoanById(id, loanRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return this.loanService.deleteLoanById(id);
    }
}
