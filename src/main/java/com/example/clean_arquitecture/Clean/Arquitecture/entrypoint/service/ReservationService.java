package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.service;

import com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.domain.Reservation;
import com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.useCase.*;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.reservation.request.ReservationRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.reservation.response.ReservationResponse;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    //Use Case
    private final SaveReservation saveReservation;
    private final GetListReservations getListReservations;
    private final GetReservationById getReservationById;
    private final DeleteReservationById deleteReservationById;
    private final UpdateReservation updateReservation;

    public ResponseEntity<ReservationResponse> saveReservation(ReservationRequest request) {
        Reservation reservation = this.saveReservation.execute(request);
        return new ResponseEntity<>(ReservationMapper.toEntityToResponse(reservation), HttpStatus.CREATED);
    }

    public ResponseEntity<List<ReservationResponse>> getAllReservations() {
        List<Reservation> reservations = this.getListReservations.execute();
        return new ResponseEntity<>(ReservationMapper.toListReservationResponse(reservations), HttpStatus.OK);
    }

    public ResponseEntity<ReservationResponse> getReservationById(String id) {
        Reservation reservation = this.getReservationById.execute(id);
        return new ResponseEntity<>(ReservationMapper.toEntityToResponse(reservation), HttpStatus.OK);
    }

    public ResponseEntity<ReservationResponse> updateReservationById(String id, ReservationRequest request) {
        Reservation reservation = this.updateReservation.execute(id, request);
        return new ResponseEntity<>(ReservationMapper.toEntityToResponse(reservation), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteReservationById(String id) {
        this.deleteReservationById.execute(id);
        return new ResponseEntity<>("Reservation with Id " + id + " deleted", HttpStatus.OK);
    }
}
