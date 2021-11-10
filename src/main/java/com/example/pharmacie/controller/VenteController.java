package com.example.pharmacie.controller;

import com.example.pharmacie.dto.VenteDto;
import com.example.pharmacie.mapper.VenteMapper;
import com.example.pharmacie.model.Vente;
import com.example.pharmacie.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/vente")
public class VenteController {
    @Autowired
    private VenteMapper venteMapper;
    @Autowired
    private VenteService venteService;

    @PostMapping
    public VenteDto save(@RequestBody VenteDto venteDto){
        Vente vente = venteMapper.toModel(venteDto);
        return venteMapper.toDto(venteService.save(vente));
    }

    @GetMapping
    public List<VenteDto> show(){
        return venteService.show().stream()
                .map(venteMapper::toDto)
                .collect(Collectors.toList());
    }
    ;//venteMapper.toDto(venteService.show());

}
