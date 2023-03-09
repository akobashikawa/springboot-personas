package com.example.personas;

import java.util.List;
import java.util.Optional;

public interface ArrayRepository extends Repository<T, L> {

    List<T> findAll();
    T save(T item);
    Optional<T> findById(Long id);
    void deleteById(Long id);
}
