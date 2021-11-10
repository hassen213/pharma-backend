package com.example.pharmacie.controller;

import com.example.pharmacie.dto.StockDto;
import com.example.pharmacie.mapper.StockMapper;
import com.example.pharmacie.model.Stock;
import com.example.pharmacie.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/stock")
public class StockController {
    @Autowired
    private StockMapper stockMapper;
    @Autowired
    private StockService stockService;

    @PostMapping
    public StockDto save(@RequestBody StockDto stockDto){
        Stock stock = stockMapper.toModel(stockDto);
        return stockMapper.toDto(stockService.save(stock));
    }
}
