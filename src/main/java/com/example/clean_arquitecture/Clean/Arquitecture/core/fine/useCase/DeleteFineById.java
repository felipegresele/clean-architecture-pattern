package com.example.clean_arquitecture.Clean.Arquitecture.core.fine.useCase;

import com.example.clean_arquitecture.Clean.Arquitecture.core.fine.contracts.FineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteFineById {

    private final FineRepository fineRepository;

    public void execute(String id) {
        this.fineRepository.delete(id);
    }

}
