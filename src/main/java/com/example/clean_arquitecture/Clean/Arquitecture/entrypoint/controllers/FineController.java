package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.controllers;

import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.fine.request.FineRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.fine.response.FineResponse;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.service.FineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(description = "Get all fines")
    @ApiResponse(responseCode = "200", description = "Search successful")
    public ResponseEntity<List<FineResponse>> getAllFines() {
        return this.fineService.getAllFines();
    }

    @PostMapping("/save")
    @Operation(description = "Save fine")
    @ApiResponse(responseCode = "201", description = "Insert successful")
    public ResponseEntity<FineResponse> save(@RequestBody FineRequest request) {
        return this.fineService.saveFine(request);
    }

    @GetMapping("/get-fine/{id}")
    @Operation(description = "Find fine by id")
    @ApiResponse(responseCode = "200", description = "Search successful")
    public ResponseEntity<FineResponse> fineById(
            @PathVariable String id) {
        return this.fineService.getFineById(id);
    }

    @PutMapping("/update/{id}")
    @Operation(description = "Find fine by id")
    @ApiResponse(responseCode = "201", description = "Updated successful")
    public ResponseEntity<FineResponse> updateFine(
            @PathVariable String id,
            @RequestBody FineRequest fineRequest) {
        return this.fineService.updateFineById(id, fineRequest);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(description = "Delete fine by id")
    @ApiResponse(responseCode = "204", description = "Deleted successful, no content")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return this.fineService.deleteFineById(id);
    }
}