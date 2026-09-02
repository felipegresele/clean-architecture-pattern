package com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.contracts.ReservationRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.domain.Reservation;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetReservationById {

    private final ReservationRepository reservationRepository;

    public Reservation execute(String id) {
        return this.reservationRepository.getReservationById(id).orElseThrow(() -> new ResourceNotFoundException("Not found reservation with id " + id));
    }

}
