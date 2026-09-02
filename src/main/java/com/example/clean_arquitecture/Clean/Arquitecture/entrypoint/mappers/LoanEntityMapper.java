package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers;

import com.example.clean_arquitecture.Clean.Arquitecture.core.fine.domain.Fine;
import com.example.clean_arquitecture.Clean.Arquitecture.core.loan.domain.Loan;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.loan.response.LoanResponse;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence.FineEntity;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence.LoanEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoanEntityMapper {

    public static LoanEntity domainToEntity(Loan loan) {
        LoanEntity entity = new LoanEntity();
        entity.setMemberId(loan.getMemberId());
        entity.setLoanDate(loan.getLoanDate());
        entity.setDueDate(loan.getDueDate());
        entity.setReturnDate(loan.getReturnDate());
        entity.setRenewalCount(loan.getRenewalCount());
        entity.setStatus(loan.getStatus());

        return entity;
    }

    public static Loan entityToDomain(LoanEntity entity) {
        Loan loan = new Loan();
        loan.setMemberId(entity.getMemberId());
        loan.setLoanDate(entity.getLoanDate());
        loan.setDueDate(entity.getDueDate());
        loan.setReturnDate(entity.getReturnDate());
        loan.setRenewalCount(entity.getRenewalCount());
        loan.setStatus(entity.getStatus());

        return loan;
    }

    public static List<Loan> listLoanDomain(List<LoanEntity> list) {
        List<Loan> listDomain = new ArrayList<>();
        for (LoanEntity loanEntity : list) {
            listDomain.add(entityToDomain(loanEntity));
        }
        return listDomain;
    }
}
