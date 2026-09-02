package com.example.clean_arquitecture.Clean.Arquitecture.dataprovider.loan;

import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence.LoanEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoanDaoRepository extends MongoRepository<LoanEntity, String> {
}
