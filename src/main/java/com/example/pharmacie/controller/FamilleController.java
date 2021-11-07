package com.example.pharmacie.controller;

import com.example.pharmacie.dto.FamilleDto;
import com.example.pharmacie.mapper.FamilleMapper;
import com.example.pharmacie.model.Famille;
import com.example.pharmacie.service.FamilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/familles")
public class FamilleController {
    @Autowired
    private FamilleService familleService;
    @Autowired
    private FamilleMapper familleMapper;

    @PostMapping
    public FamilleDto save(@RequestBody FamilleDto familleDto){
        Famille famille = familleMapper.toModel(familleDto);
        return familleMapper.toDto(familleService.save(famille));
    }

    @GetMapping
    public List<FamilleDto> getListFamille(){
        return familleService.getListFamille().stream()
                .map(familleMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping
    public FamilleDto updateFamille(@RequestBody FamilleDto familleDto){
        Famille famille = familleMapper.toModel(familleDto);
        return familleMapper.toDto(familleService.updateFamille(famille));
    }




}
