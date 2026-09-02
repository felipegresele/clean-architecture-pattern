package com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.contracts;

import com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.domain.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    Reservation save(Reservation reservation);

    Optional<Reservation> getReservationById(String id);

    List<Reservation> getAllReservations();

    void delete(String id);
}
