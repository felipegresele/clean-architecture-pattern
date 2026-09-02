package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers;

import com.example.clean_arquitecture.Clean.Arquitecture.core.book.domain.Book;
import com.example.clean_arquitecture.Clean.Arquitecture.core.fine.domain.Fine;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.fine.response.FineResponse;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence.BookEntity;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.persistence.FineEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FineEntityMapper {

    public static FineEntity domainToEntity(Fine fine) {
        FineEntity entity = new FineEntity();
        entity.setAmount(fine.getAmount());
        entity.setStatus(fine.getStatus());
        entity.setGeneratedDate(fine.getGeneratedDate());
        entity.setPaidDate(fine.getPaidDate());
        entity.setLoanId(fine.getLoanId());
        entity.setMemberId(fine.getMemberId());

        return entity;
    }

    public static Fine entityToDomain(FineEntity entity) {
        Fine fine = new Fine();
        fine.setAmount(entity.getAmount());
        fine.setStatus(entity.getStatus());
        fine.setGeneratedDate(entity.getGeneratedDate());
        fine.setPaidDate(entity.getPaidDate());
        fine.setLoanId(entity.getLoanId());
        fine.setMemberId(entity.getMemberId());

        return fine;
    }

    public static List<Fine> listFineDomain(List<FineEntity> list) {
        List<Fine> listDomain = new ArrayList<>();
        for (FineEntity fineEntity : list) {
            listDomain.add(entityToDomain(fineEntity));
        }
        return listDomain;
    }
}
