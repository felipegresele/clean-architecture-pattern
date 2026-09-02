package com.example.clean_arquitecture.Clean.Arquitecture.core.fine.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.fine.contracts.FineRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.fine.domain.Fine;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetFineById {

    private final FineRepository fineRepository;

    public Fine execute(String id) {
        return this.fineRepository.getFineById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found fine with id " + id));
    }

}
