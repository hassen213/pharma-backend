package com.example.pharmacie.controller;

import com.example.pharmacie.dto.StockDto;
import com.example.pharmacie.dto.StockMedicamentDto;
import com.example.pharmacie.mapper.StockMapper;
import com.example.pharmacie.mapper.StockMedicamentMapper;
import com.example.pharmacie.model.Medicament;
import com.example.pharmacie.model.Stock;
import com.example.pharmacie.model.StockMedicament;
import com.example.pharmacie.service.MedicamentService;
import com.example.pharmacie.service.StockMedicamentService;
import com.example.pharmacie.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/stock")
public class StockController {
    @Autowired
    private StockMapper stockMapper;
    @Autowired
    private StockMedicamentMapper stockMedicamentMapper;
    @Autowired
    private StockService stockService;
    @Autowired
    private StockMedicamentService stockMedicamentService;
    @Autowired
    private MedicamentService medicamentService;

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

    @PostMapping("add-to-stock")
    public StockMedicamentDto addMedToStock(@RequestBody StockMedicamentDto dto){

        Medicament medicament = medicamentService.findById(dto.getMedicamentId())
                .orElseThrow(() -> new IllegalArgumentException("medicament does not exist"));
        Stock stock = stockService.findById(dto.getStockId())
                .orElseThrow(() -> new IllegalArgumentException("stock does not exist"));
        StockMedicament stockMedicament = stockMedicamentService

                .findUnique(dto.getMedicamentId(), dto.getStockId())
                .orElse(StockMedicament.builder()
                        .medicament(medicament)
                        .stock(stock)
                        .build());
        stockMedicament.setQuantity(stockMedicament.getQuantity() + dto.getQuantity());
        return stockMedicamentMapper.toDto(stockMedicamentService.save(stockMedicament));
    }

    @GetMapping("/get/stock/medicament/list")
    public List<StockMedicamentDto> getListStockMed(){
        return stockMedicamentService.getListStockMed().stream()
                .map(stockMedicamentMapper::toDto)
                .collect(Collectors.toList());
    }
}

//moi
//   Optional<StockMedicament> fromDb = stockMedicamentService.findUnique(dto.getMedicamentId(), dto.getStockId());
//        StockMedicament stockMedicament;
//        if(fromDb.isPresent()){
//            stockMedicament = fromDb.get();
//        }
//        else {
//            stockMedicament = new StockMedicament();
//            Optional<Medicament> medOptional = medicamentService.findById(dto.getMedicamentId());
//            if (medOptional.isPresent()){
//                stockMedicament.setMedicament(medOptional.get());
//            }
//            else {
//                throw new IllegalArgumentException();
//            }
//            Optional<Stock> stockOptional = stockService.findById(dto.getStockId());
//            if(stockOptional.isPresent()){
//                stockMedicament.setStock(stockOptional.get());
//            }
//            else {
//                throw new IllegalArgumentException();
//            }
//        }
//        stockMedicament.setQuantity(stockMedicament.getQuantity()+ dto.getQuantity());
//
//        return stockMedicamentMapper.toDto(stockMedicamentService.save(stockMedicament));



//brahim
//        Optional<StockMedicament> fromDb = stockMedicamentService.findUnique(dto.getMedicamentId(), dto.getStockId());
//        StockMedicament stockMedicament;
//        if (fromDb.isPresent()) {
//            stockMedicament = fromDb.get();
//        }
//        else {
//            stockMedicament = new StockMedicament();
//
//            Optional<Medicament> medicamentOptional = medicamentService.findById(dto.getMedicamentId());
//            if (medicamentOptional.isPresent()) {
//                stockMedicament.setMedicament(medicamentOptional.get());
//            } else {
//                throw new IllegalArgumentException();
//            }
//
//            Optional<Stock> stockOptional = stockService.findById(dto.getStockId());
//            if (stockOptional.isPresent()) {
//                stockMedicament.setStock(stockOptional.get());
//            } else {
//                throw new IllegalArgumentException();
//            }
//        }
//
//        stockMedicament.setQuantity(stockMedicament.getQuantity() + dto.getQuantity());






// find stock if exist
//        StockMedicament stockMedicament = stockMedicamentService
//                .findUnique(dto.getMedicamentId(), dto.getStockId())
//                .orElse(
//                        StockMedicament.builder()
//                        .medicament(medicamentService.findById(dto.getMedicamentId())
//                                .orElseThrow(() -> new IllegalArgumentException("medicament does not exist")))
//                        .stock(stockService.findById(dto.getStockId())
//                                .orElseThrow(() -> new IllegalArgumentException("stock does not exist")))
//                        .build());
//        stockMedicament.setQuantity(stockMedicament.getQuantity() + dto.getQuantity());




