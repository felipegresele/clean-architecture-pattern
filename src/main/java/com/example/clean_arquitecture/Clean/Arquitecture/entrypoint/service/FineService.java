package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.service;

import com.example.clean_arquitecture.Clean.Arquitecture.core.fine.domain.Fine;
import com.example.clean_arquitecture.Clean.Arquitecture.core.fine.useCase.*;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.fine.request.FineRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.fine.response.FineResponse;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.FineMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FineService {

    //Use Case
    private final SaveFine saveFine;
    private final GetListFines getListFines;
    private final GetFineById getFineById;
    private final DeleteFineById deleteFineById;
    private final UpdateFine updateFine;

    public ResponseEntity<FineResponse> saveFine(FineRequest request) {
        Fine fine = this.saveFine.execute(request);
        return new ResponseEntity<>(FineMapper.toEntityToResponse(fine), HttpStatus.CREATED);
    }

    public ResponseEntity<List<FineResponse>> getAllFines() {
        List<Fine> fines = this.getListFines.execute();
        return new ResponseEntity<>(FineMapper.toListFineResponse(fines),HttpStatus.OK);
    }

    public ResponseEntity<FineResponse> getFineById(String id) {
        Fine fine = this.getFineById.execute(id);
        return new ResponseEntity<>(FineMapper.toEntityToResponse(fine), HttpStatus.OK);
    }

    public ResponseEntity<FineResponse> updateFineById(String id, FineRequest request) {
        Fine fine = this.updateFine.execute(id, request);
        return new ResponseEntity<>(FineMapper.toEntityToResponse(fine), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteFineById(String id) {
        this.deleteFineById.execute(id);
        return new ResponseEntity<>("Fine with Id " + id + " deleted", HttpStatus.OK);
    }
}
