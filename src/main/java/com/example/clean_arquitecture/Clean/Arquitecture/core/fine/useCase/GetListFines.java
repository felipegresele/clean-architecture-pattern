package com.example.clean_arquitecture.Clean.Arquitecture.core.fine.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.fine.contracts.FineRepository;
import com.example.clean_arquitecture.Clean.Arquitecture.core.fine.domain.Fine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetListFines {

    private final FineRepository fineRepository;

    public List<Fine> execute() {
        return this.fineRepository.getAllFines();
    }

}
