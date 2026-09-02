package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.reservation.response;

import com.example.clean_arquitecture.Clean.Arquitecture.core.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {
    String bookId;
    String memberId;
    LocalDateTime reservationDate;
    LocalDateTime expiresAt;        // prazo pra retirar após ser notificado
    ReservationStatus status = ReservationStatus.WAITING;
    Integer queuePosition;
}
