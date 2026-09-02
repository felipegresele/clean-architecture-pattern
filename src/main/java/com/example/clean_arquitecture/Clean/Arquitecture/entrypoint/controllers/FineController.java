package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.controllers;

import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.fine.request.FineRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.fine.response.FineResponse;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.service.FineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fine")
public class FineController {

    private final FineService fineService;

    public FineController(FineService fineService) {
        this.fineService = fineService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<FineResponse>> getAllBooks() {
        return this.fineService.getAllFines();
    }

    @PostMapping("/save")
    public ResponseEntity<FineResponse> save(@RequestBody FineRequest request) {
        return this.fineService.saveFine(request);
    }

    @GetMapping("/get-fine/{id}")
    public ResponseEntity<FineResponse> findBookByIdOrName(
            @PathVariable String id) {
        return this.fineService.getFineById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FineResponse> updateBook(
            @PathVariable String id,
            @RequestBody FineRequest fineRequest) {
        return this.fineService.updateFineById(id, fineRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return this.fineService.deleteFineById(id);
    }
}