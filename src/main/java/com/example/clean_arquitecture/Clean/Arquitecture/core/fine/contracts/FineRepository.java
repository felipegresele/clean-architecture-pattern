package com.example.clean_arquitecture.Clean.Arquitecture.core.fine.contracts;

import com.example.clean_arquitecture.Clean.Arquitecture.core.fine.domain.Fine;

import java.util.List;
import java.util.Optional;

public interface FineRepository {
    Fine save(Fine fine);

    Optional<Fine> getFineById(String id);

    List<Fine> getAllFines();

    void delete(String id);
}
