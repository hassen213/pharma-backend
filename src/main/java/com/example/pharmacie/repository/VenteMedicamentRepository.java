package com.example.pharmacie.repository;

import com.example.pharmacie.model.VenteMedicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenteMedicamentRepository extends JpaRepository<VenteMedicament, Long> {
}
