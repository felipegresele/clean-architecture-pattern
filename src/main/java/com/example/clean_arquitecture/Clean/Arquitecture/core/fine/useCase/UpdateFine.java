package com.example.clean_arquitecture.Clean.Arquitecture.core.fine.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.fine.contracts.FineRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.fine.domain.Fine;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.dtos.fine.request.FineRequest;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.exceptions.ResourceNotFoundException;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.mappers.FineMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateFine {

    private final FineRepository fineRepository;

    public Fine execute(String id, FineRequest fineRequest) {
        Fine fine = this.fineRepository.getFineById(id).orElseThrow(() -> new ResourceNotFoundException("Not found fine with id " + id));
        FineMapper.updateFine(fine, fineRequest);

        return fineRepository.save(fine);
    }

}
