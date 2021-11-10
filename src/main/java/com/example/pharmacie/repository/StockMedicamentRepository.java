package com.example.pharmacie.repository;

import com.example.pharmacie.model.StockMedicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMedicamentRepository extends JpaRepository<StockMedicament, Long> {
}
