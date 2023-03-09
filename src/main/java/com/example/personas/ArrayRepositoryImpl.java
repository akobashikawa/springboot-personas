package com.example.personas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class ArrayRepositoryImpl<T, L> {
    public List<T> items = new ArrayList<>();
    public Long idActual = 0L;

    public List<T> findAll() {
        return items;
    }

    public T save(T item) {
        if (item.getId() == null) {
            idActual++;
            item.setId(idActual);
            items.add(item);
        } else {
            int index = items.indexOf(item);
            if (index >= 0) {
                items.set(index, item);
            } else {
                items.add(item);
            }
        }
        return item;
    }

    public Optional<T> findById(Long id) {
        return items.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public void deleteById(Long id) {
        items.removeIf(p -> p.getId().equals(id));
    }
}
