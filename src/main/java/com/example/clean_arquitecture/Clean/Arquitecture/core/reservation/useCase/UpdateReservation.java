package com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.contracts.ReservationRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.domain.Reservation;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.reservation.request.ReservationRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.exceptions.ResourceNotFoundException;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateReservation {

    private final ReservationRepository reservationRepository;

    public Reservation execute(String id, ReservationRequest reservationRequest) {
        Reservation reservation = this.reservationRepository.getReservationById(id).orElseThrow(() -> new ResourceNotFoundException("Not found reservation with id " + id));
        ReservationMapper.updateReservation(reservation, reservationRequest);

        return reservationRepository.save(reservation);
    }

}
