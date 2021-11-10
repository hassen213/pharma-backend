package com.example.pharmacie.repository;

import com.example.pharmacie.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenteRepository extends JpaRepository<Vente, Long> {
}
