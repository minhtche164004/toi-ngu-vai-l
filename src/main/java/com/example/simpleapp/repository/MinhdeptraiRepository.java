package com.example.simpleapp.repository;

import com.example.simpleapp.model.Minhdeptrai;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MinhdeptraiRepository extends CrudRepository<Minhdeptrai, String> {
    List<Minhdeptrai> findAllByName(String name);
    List<Minhdeptrai> findByAge(int age);
}
