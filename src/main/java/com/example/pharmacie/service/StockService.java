package com.example.pharmacie.service;

import com.example.pharmacie.mapper.StockMapper;
import com.example.pharmacie.model.Stock;
import com.example.pharmacie.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockMapper stockMapper;

    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }


    public List<Stock> get(){
        return stockRepository.findAll();
    }

    public Optional<Stock> findById(Long stockId) {
        return stockRepository.findById(stockId);
    }
}
