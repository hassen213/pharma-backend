package com.example.pharmacie.repository;

import com.example.pharmacie.model.StockMedicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StockMedicamentRepository extends JpaRepository<StockMedicament, Long> {
    @Query("select sm from StockMedicament sm " + "where sm.medicament.id = :mId and sm.stock.id = :sId")
    Optional<StockMedicament> findUnique(@Param("mId") Long mId, @Param("sId") Long sId);

}

