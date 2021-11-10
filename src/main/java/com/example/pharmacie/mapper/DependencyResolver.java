package com.example.pharmacie.mapper;

import com.example.pharmacie.model.Famille;
import com.example.pharmacie.model.Medicament;
import com.example.pharmacie.model.Stock;
import com.example.pharmacie.repository.FamilleRepository;
import com.example.pharmacie.repository.MedicamentRepository;
import com.example.pharmacie.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class DependencyResolver {
    public static DependencyResolver instance;
    @PostConstruct
    public void init(){
        instance = this;
    }

    @Autowired
    private FamilleRepository familleRepository;

    public Famille familleById(Long id) {
        return familleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
