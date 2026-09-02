package com.example.clean_arquitecture.Clean.Arquitecture.dataprovider.fine;

import com.example.clean_arquitecture.Clean.Arquitecture.core.fine.contracts.FineRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.fine.domain.Fine;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.exceptions.ResourceNotFoundException;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.FineEntityMapper;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence.FineEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FineRepositoryImpl implements FineRepository {

    public static final String FINE_COLLECTION_NAME = "Fine";

    private final FineDaoRepository dao;
    private final MongoTemplate mongoTemplate;

    public FineRepositoryImpl(FineDaoRepository dao, MongoTemplate mongoTemplate) {
        this.dao = dao;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Fine save(Fine fine) {
        FineEntity fineEntity = FineEntityMapper.domainToEntity(fine);
        this.dao.save(fineEntity);
        return FineEntityMapper.entityToDomain(fineEntity);
    }

    @Override
    public Optional<Fine> getFineById(String id) {
        return dao.findById(id).map(FineEntityMapper::entityToDomain);
    }

    @Override
    public List<Fine> getAllFines() {
        List<FineEntity> fineEntityList = this.dao.findAll();
        return FineEntityMapper.listFineDomain(fineEntityList);
    }

    @Override
    public void delete(String id) {
        FineEntity fine = this.dao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found fine with Id: " + id));
        this.dao.delete(fine);
    }
}
