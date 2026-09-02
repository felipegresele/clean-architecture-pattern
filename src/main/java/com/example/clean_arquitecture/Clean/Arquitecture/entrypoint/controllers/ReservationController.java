package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.controllers;

import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.reservation.request.ReservationRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.reservation.response.ReservationResponse;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<ReservationResponse>> getAllReservations() {
        return this.reservationService.getAllReservations();
    }

    @PostMapping("/save")
    public ResponseEntity<ReservationResponse> save(@RequestBody ReservationRequest request) {
        return this.reservationService.saveReservation(request);
    }

    @GetMapping("/get-reservation/{id}")
    public ResponseEntity<ReservationResponse> findReservationById(
            @PathVariable String id) {
        return this.reservationService.getReservationById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ReservationResponse> updateReservation(
            @PathVariable String id,
            @RequestBody ReservationRequest reservationRequest) {
        return this.reservationService.updateReservationById(id, reservationRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return this.reservationService.deleteReservationById(id);
    }
}
