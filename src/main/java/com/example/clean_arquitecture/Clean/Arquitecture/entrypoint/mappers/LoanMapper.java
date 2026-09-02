package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers;

import com.example.clean_arquitecture.Clean.Arquitecture.core.loan.domain.Loan;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.loan.request.LoanRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.loan.response.LoanResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoanMapper {

    public static LoanResponse toEntityToResponse(Loan loan) {
        LoanResponse response = new LoanResponse();
        response.setMemberId(loan.getMemberId());
        response.setLoanDate(loan.getLoanDate());
        response.setDueDate(loan.getDueDate());
        response.setReturnDate(loan.getReturnDate());
        response.setRenewalCount(loan.getRenewalCount());
        response.setStatus(loan.getStatus());

        return response;
    }

    public Loan toRequestToEntity(LoanRequest request) {
        Loan entity = new Loan();
        entity.setMemberId(request.getMemberId());
        entity.setLoanDate(request.getLoanDate());
        entity.setDueDate(request.getDueDate());
        entity.setReturnDate(request.getReturnDate());
        entity.setRenewalCount(request.getRenewalCount());
        entity.setStatus(request.getStatus());

        return entity;
    }

    public static List<LoanResponse> toListLoanResponse(List<Loan> loanList) {
        List<LoanResponse> responseList = new ArrayList<>();
        for (Loan loan : loanList) {
            LoanResponse loanResponse = toEntityToResponse(loan);
            responseList.add(loanResponse);
        }
        return responseList;
    }

    public static void updateLoan(Loan entity, LoanRequest request) {
        entity.setMemberId(request.getMemberId());
        entity.setLoanDate(request.getLoanDate());
        entity.setDueDate(request.getDueDate());
        entity.setReturnDate(request.getReturnDate());
        entity.setRenewalCount(request.getRenewalCount());
        entity.setStatus(request.getStatus());
    }

}
