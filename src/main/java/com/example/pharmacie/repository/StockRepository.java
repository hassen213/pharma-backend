package com.example.pharmacie.repository;

import com.example.pharmacie.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
