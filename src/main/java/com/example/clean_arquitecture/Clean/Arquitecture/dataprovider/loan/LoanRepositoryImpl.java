package com.example.clean_arquitecture.Clean.Arquitecture.dataprovider.loan;

import com.example.clean_arquitecture.Clean.Arquitecture.core.loan.contracts.LoanRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.loan.domain.Loan;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.exceptions.ResourceNotFoundException;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.LoanEntityMapper;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence.LoanEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LoanRepositoryImpl implements LoanRepository {

    public static final String LOAN_COLLECTION_NAME = "Loan";

    private final LoanDaoRepository dao;
    private final MongoTemplate mongoTemplate;

    public LoanRepositoryImpl(LoanDaoRepository dao, MongoTemplate mongoTemplate) {
        this.dao = dao;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Loan save(Loan loan) {
        LoanEntity loanEntity = LoanEntityMapper.domainToEntity(loan);
        this.dao.save(loanEntity);
        return LoanEntityMapper.entityToDomain(loanEntity);
    }

    @Override
    public Optional<Loan> getLoanById(String id) {
        return this.dao.findById(id).map(LoanEntityMapper::entityToDomain);
    }

    @Override
    public List<Loan> getAllLoans() {
        List<LoanEntity> loanEntityList = this.dao.findAll();
        return LoanEntityMapper.listLoanDomain(loanEntityList);
    }

    @Override
    public void delete(String id) {
        LoanEntity loanEntity = this.dao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found loan with Id: " + id));
        this.dao.delete(loanEntity);
    }
}
