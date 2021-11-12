package com.example.pharmacie.service;

import com.example.pharmacie.model.StockMedicament;
import com.example.pharmacie.repository.StockMedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockMedicamentService {
    @Autowired
    private StockMedicamentRepository stockMedicamentRepository;

    public Optional<StockMedicament> findUnique(Long medicamentId, Long stockId) {
        return stockMedicamentRepository.findUnique(medicamentId, stockId);
    }

    public StockMedicament save(StockMedicament stockMedicament) {
        return stockMedicamentRepository.save(stockMedicament);
    }

    public List<StockMedicament> getListStockMed() {
        return stockMedicamentRepository.findAll();
    }
}
