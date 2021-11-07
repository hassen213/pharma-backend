package com.example.pharmacie.repository;

import com.example.pharmacie.model.Famille;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilleRepository extends JpaRepository<Famille, Long> {
}
