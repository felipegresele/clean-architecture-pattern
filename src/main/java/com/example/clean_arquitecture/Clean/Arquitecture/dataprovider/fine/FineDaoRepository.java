package com.example.clean_arquitecture.Clean.Arquitecture.dataprovider.fine;

import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence.FineEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FineDaoRepository extends MongoRepository<FineEntity, String> {
}
