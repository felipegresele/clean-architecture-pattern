package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers;

import com.example.clean_arquitecture.Clean.Arquitecture.core.member.domain.Member;
import com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.domain.Reservation;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.reservation.response.ReservationResponse;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence.MemberEntity;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence.ReservationEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationEntityMapper {

    public static ReservationEntity domainToEntity(Reservation reservation) {
        ReservationEntity entity = new ReservationEntity();
        entity.setBookId(reservation.getBookId());
        entity.setMemberId(reservation.getMemberId());
        entity.setReservationDate(reservation.getReservationDate());
        entity.setExpiresAt(reservation.getExpiresAt());
        entity.setStatus(reservation.getStatus());
        entity.setQueuePosition(reservation.getQueuePosition());

        return entity;
    }

    public static Reservation entityToDomain(ReservationEntity entity) {
        Reservation reservation = new Reservation();
        reservation.setBookId(entity.getBookId());
        reservation.setMemberId(entity.getMemberId());
        reservation.setReservationDate(entity.getReservationDate());
        reservation.setExpiresAt(entity.getExpiresAt());
        reservation.setStatus(entity.getStatus());
        reservation.setQueuePosition(entity.getQueuePosition());

        return reservation;
    }

    public static List<Reservation> listReservationDomain(List<ReservationEntity> list) {
        List<Reservation> listDomain = new ArrayList<>();
        for (ReservationEntity reservationEntity : list) {
            listDomain.add(entityToDomain(reservationEntity));
        }
        return listDomain;
    }
}
