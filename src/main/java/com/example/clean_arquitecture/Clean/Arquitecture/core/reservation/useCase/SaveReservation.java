package com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.contracts.ReservationRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.domain.Reservation;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.reservation.request.ReservationRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveReservation {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public Reservation execute(ReservationRequest request) {
        Reservation reservation = this.reservationMapper.toRequestToEntity(request);
        this.reservationRepository.save(reservation);
        return reservation;
    }

}
