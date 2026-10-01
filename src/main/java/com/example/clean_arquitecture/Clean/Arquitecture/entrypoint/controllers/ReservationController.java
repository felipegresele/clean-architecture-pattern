package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.controllers;

import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.reservation.request.ReservationRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.reservation.response.ReservationResponse;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(description = "Get all reservation")
    @ApiResponse(responseCode = "200", description = "Search successful")
    public ResponseEntity<List<ReservationResponse>> getAllReservations() {
        return this.reservationService.getAllReservations();
    }

    @PostMapping("/save")
    @Operation(description = "Save reservation")
    @ApiResponse(responseCode = "201", description = "Insert successful")
    public ResponseEntity<ReservationResponse> save(@RequestBody ReservationRequest request) {
        return this.reservationService.saveReservation(request);
    }

    @GetMapping("/get-reservation/{id}")
    @Operation(description = "Find reservation by id")
    @ApiResponse(responseCode = "200", description = "Search successful")
    public ResponseEntity<ReservationResponse> findReservationById(
            @PathVariable String id) {
        return this.reservationService.getReservationById(id);
    }

    @PutMapping("/update/{id}")
    @Operation(description = "Update reservation by id")
    @ApiResponse(responseCode = "201", description = "Updated successful")
    public ResponseEntity<ReservationResponse> updateReservation(
            @PathVariable String id,
            @RequestBody ReservationRequest reservationRequest) {
        return this.reservationService.updateReservationById(id, reservationRequest);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(description = "Delete reservation by id")
    @ApiResponse(responseCode = "204", description = "Deleted successful, no content")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return this.reservationService.deleteReservationById(id);
    }
}
