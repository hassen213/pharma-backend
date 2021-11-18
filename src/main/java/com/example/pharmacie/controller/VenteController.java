package com.example.pharmacie.controller;

import com.example.pharmacie.dto.VenteDto;
import com.example.pharmacie.mapper.VenteMapper;
import com.example.pharmacie.model.*;
import com.example.pharmacie.repository.MedicamentRepository;
import com.example.pharmacie.repository.StockMedicamentRepository;
import com.example.pharmacie.repository.StockRepository;
import com.example.pharmacie.repository.VenteMedicamentRepository;
import com.example.pharmacie.service.MedicamentService;
import com.example.pharmacie.service.StockMedicamentService;
import com.example.pharmacie.service.StockService;
import com.example.pharmacie.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/vente")
public class VenteController {
    @Autowired
    private VenteMapper venteMapper;
    @Autowired
    private VenteService venteService;
    @Autowired
    private MedicamentRepository medicamentRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockMedicamentService stockMedicamentService;
    @Autowired
    private MedicamentService medicamentService;
    @Autowired
    private StockService stockService;
    @Autowired
    private StockMedicamentRepository stockMedicamentRepository;

    @Autowired
    private VenteMedicamentRepository venteMedicamentRepository;

    @PostMapping
    public void save(@RequestBody VenteDto venteDto){
        VenteMedicament venteMedicament = new VenteMedicament();

        Vente vente = new Vente();
        vente.setDateDeVente(venteDto.getDateDeVente());

//        Medicament medicament = medicamentRepository.findById(venteDto.getMedId())
//                .orElseThrow(()-> new IllegalArgumentException("has no medicament with that id"));
//
//        Stock stock = stockRepository.findById(venteDto.getStockId())
//                .orElseThrow(()-> new IllegalArgumentException("has no stock with that id"));
//
//        StockMedicament stockMedicament = stockMedicamentService.findUnique(venteDto.getMedId(), venteDto.getStockId())
//                .orElse(StockMedicament.builder()
//                        .medicament(medicament)
//                        .stock(stock)
//                        .build());
//
//        stockMedicament.setQuantity(stockMedicament.getQuantity() - venteDto.getQuantity());

        StockMedicament stockMedicament = stockMedicamentService
                .findUnique(venteDto.getMedId(), venteDto.getStockId())
                .orElse(
                        StockMedicament.builder()
                        .medicament(medicamentService.findById(venteDto.getMedId())
                                .orElseThrow(() -> new IllegalArgumentException("medicament does not exist")))
                        .stock(stockService.findById(venteDto.getStockId())
                                .orElseThrow(() -> new IllegalArgumentException("stock does not exist")))
                        .build());
        stockMedicament.setQuantity(stockMedicament.getQuantity() - venteDto.getQuantity());

        stockMedicamentService.save(stockMedicament);
        venteService.save(vente);

        venteMedicament.setVente(vente);
        venteMedicament.setStockMedicament(stockMedicament);

        venteMedicamentRepository.save(venteMedicament);



    }


}
