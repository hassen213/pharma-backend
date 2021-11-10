package com.example.pharmacie.controller;

import com.example.pharmacie.dto.StockDto;
import com.example.pharmacie.mapper.StockMapper;
import com.example.pharmacie.model.Stock;
import com.example.pharmacie.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    @GetMapping
    public List<StockDto> get(){
        return stockService.get().stream()
                .map(stockMapper::toDto)
                .collect(Collectors.toList());
    }

}
