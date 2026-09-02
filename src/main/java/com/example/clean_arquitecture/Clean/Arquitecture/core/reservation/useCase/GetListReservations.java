package com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.contracts.ReservationRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.domain.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetListReservations {

    private final ReservationRepository reservationRepository;

    public List<Reservation> execute() {
        return this.reservationRepository.getAllReservations();
    }

}
