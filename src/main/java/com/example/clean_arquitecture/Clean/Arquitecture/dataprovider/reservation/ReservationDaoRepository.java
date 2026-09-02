package com.example.clean_arquitecture.Clean.Arquitecture.dataprovider.reservation;

import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence.ReservationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationDaoRepository extends MongoRepository<ReservationEntity, String> {
}
