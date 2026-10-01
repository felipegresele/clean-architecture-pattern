package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.controllers;

import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.loan.request.LoanRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.loan.response.LoanResponse;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.service.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(description = "Get all loan")
    @ApiResponse(responseCode = "200", description = "Search successful")
    public ResponseEntity<List<LoanResponse>> getAllLoans() {
        return this.loanService.getAllLoans();
    }


    @PostMapping("/save")
    @Operation(description = "Save loan")
    @ApiResponse(responseCode = "201", description = "Insert successful")
    public ResponseEntity<LoanResponse> save(@RequestBody LoanRequest request) {
        return this.loanService.saveLoan(request);
    }

    @GetMapping("/get-loan/{id}")
    @Operation(description = "Find loan by id")
    @ApiResponse(responseCode = "200", description = "Search successful")
    public ResponseEntity<LoanResponse> findLoanById(
            @PathVariable String id) {
        return this.loanService.getLoanById(id);
    }

    @PutMapping("/update/{id}")
    @Operation(description = "Update loan by id")
    @ApiResponse(responseCode = "201", description = "Updated successful")
    public ResponseEntity<LoanResponse> updateLoan(
            @PathVariable String id,
            @RequestBody LoanRequest loanRequest) {
        return this.loanService.updateLoanById(id, loanRequest);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(description = "Delete loan by id")
    @ApiResponse(responseCode = "204", description = "Deleted successful, no content")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return this.loanService.deleteLoanById(id);
    }
}
