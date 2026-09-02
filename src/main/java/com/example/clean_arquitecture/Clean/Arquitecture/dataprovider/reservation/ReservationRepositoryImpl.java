package com.example.clean_arquitecture.Clean.Arquitecture.dataprovider.reservation;

import com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.contracts.ReservationRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.domain.Reservation;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.exceptions.ResourceNotFoundException;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.ReservationEntityMapper;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence.ReservationEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

    public static final String RESERVATION_COLLECTION_NAME = "Reservation";

    private final ReservationDaoRepository dao;
    private final MongoTemplate mongoTemplate;

    public ReservationRepositoryImpl(ReservationDaoRepository dao, MongoTemplate mongoTemplate) {
        this.dao = dao;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Reservation save(Reservation reservation) {
        ReservationEntity reservationEntity = ReservationEntityMapper.domainToEntity(reservation);
        this.dao.save(reservationEntity);
        return ReservationEntityMapper.entityToDomain(reservationEntity);
    }

    @Override
    public Optional<Reservation> getReservationById(String id) {
        return this.dao.findById(id).map(ReservationEntityMapper::entityToDomain);
    }

    @Override
    public List<Reservation> getAllReservations() {
        List<ReservationEntity> reservationEntityList = this.dao.findAll();
        return ReservationEntityMapper.listReservationDomain(reservationEntityList);
    }

    @Override
    public void delete(String id) {
        ReservationEntity reservationEntity = this.dao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found reservation with Id: " + id));
        this.dao.delete(reservationEntity);
    }
}
