package com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.contracts.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteReservationById {

    private final ReservationRepository reservationRepository;

    public void execute(String id) {
        this.reservationRepository.delete(id);
    }

}
