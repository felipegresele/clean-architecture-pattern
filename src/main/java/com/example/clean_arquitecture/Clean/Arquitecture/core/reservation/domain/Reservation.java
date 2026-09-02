package com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.domain;

import com.example.clean_arquitecture.Clean.Arquitecture.core.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    String bookId;               // reserva é pelo livro, não por exemplar específico
    String memberId;
    LocalDateTime reservationDate;
    LocalDateTime expiresAt;        // prazo pra retirar após ser notificado
    ReservationStatus status = ReservationStatus.WAITING;
    Integer queuePosition;

}
