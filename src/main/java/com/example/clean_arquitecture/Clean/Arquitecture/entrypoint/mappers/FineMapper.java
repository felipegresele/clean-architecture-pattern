package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers;

import com.example.clean_arquitecture.Clean.Arquitecture.core.fine.domain.Fine;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.fine.request.FineRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.fine.response.FineResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FineMapper {

    public static FineResponse toEntityToResponse(Fine fine) {
        FineResponse response = new FineResponse();
        response.setAmount(fine.getAmount());
        response.setStatus(fine.getStatus());
        response.setGeneratedDate(fine.getGeneratedDate());
        response.setPaidDate(fine.getPaidDate());
        response.setLoanId(fine.getLoanId());
        response.setMemberId(fine.getMemberId());

        return response;
    }

    public Fine toRequestToEntity(FineRequest request) {
        Fine entity = new Fine();
        entity.setAmount(request.getAmount());
        entity.setStatus(request.getStatus());
        entity.setGeneratedDate(request.getGeneratedDate());
        entity.setPaidDate(request.getPaidDate());
        entity.setLoanId(request.getLoanId());
        entity.setMemberId(request.getMemberId());

        return entity;
    }

    public static List<FineResponse> toListFineResponse(List<Fine> fineList) {
        List<FineResponse> responseList = new ArrayList<>();
        for (Fine fine : fineList) {
            FineResponse fineResponse = toEntityToResponse(fine);
            responseList.add(fineResponse);
        }
        return responseList;
    }

    public static void updateFine(Fine entity, FineRequest request) {
        entity.setAmount(request.getAmount());
        entity.setStatus(request.getStatus());
        entity.setGeneratedDate(request.getGeneratedDate());
        entity.setPaidDate(request.getPaidDate());
        entity.setLoanId(request.getLoanId());
        entity.setMemberId(request.getMemberId());
    }

}
