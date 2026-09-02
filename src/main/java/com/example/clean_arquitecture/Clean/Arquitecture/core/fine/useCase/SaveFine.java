package com.example.clean_arquitecture.Clean.Arquitecture.core.fine.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.fine.contracts.FineRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.fine.domain.Fine;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.fine.request.FineRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.FineMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveFine {

    private final FineRepository fineRepository;
    private final FineMapper fineMapper;

    public Fine execute(FineRequest request) {
        Fine fine = this.fineMapper.toRequestToEntity(request);
        this.fineRepository.save(fine);
        return fine;
    }

}
