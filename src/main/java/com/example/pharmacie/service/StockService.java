package com.example.pharmacie.service;

import com.example.pharmacie.model.Stock;
import com.example.pharmacie.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;
    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }
}
