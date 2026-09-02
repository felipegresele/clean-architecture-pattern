package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers;

import com.example.clean_arquitecture.Clean.Arquitecture.core.reservation.domain.Reservation;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.reservation.request.ReservationRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.reservation.response.ReservationResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationMapper {

    public static ReservationResponse toEntityToResponse(Reservation reservation) {
        ReservationResponse response = new ReservationResponse();
        response.setBookId(reservation.getBookId());
        response.setMemberId(reservation.getMemberId());
        response.setReservationDate(reservation.getReservationDate());
        response.setExpiresAt(reservation.getExpiresAt());
        response.setStatus(reservation.getStatus());
        response.setQueuePosition(reservation.getQueuePosition());

        return response;
    }

    public Reservation toRequestToEntity(ReservationRequest request) {
        Reservation entity = new Reservation();
        entity.setBookId(request.getBookId());
        entity.setMemberId(request.getMemberId());
        entity.setReservationDate(request.getReservationDate());
        entity.setExpiresAt(request.getExpiresAt());
        entity.setStatus(request.getStatus());
        entity.setQueuePosition(request.getQueuePosition());

        return entity;
    }

    public static List<ReservationResponse> toListReservationResponse(List<Reservation> reservationList) {
        List<ReservationResponse> responseList = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            ReservationResponse reservationResponse = toEntityToResponse(reservation);
            responseList.add(reservationResponse);
        }
        return responseList;
    }

    public static void updateReservation(Reservation entity, ReservationRequest request) {
        entity.setBookId(request.getBookId());
        entity.setMemberId(request.getMemberId());
        entity.setReservationDate(request.getReservationDate());
        entity.setExpiresAt(request.getExpiresAt());
        entity.setStatus(request.getStatus());
        entity.setQueuePosition(request.getQueuePosition());
    }

}
