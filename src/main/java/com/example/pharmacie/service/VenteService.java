package com.example.pharmacie.service;

import com.example.pharmacie.model.Vente;
import com.example.pharmacie.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteService {
    @Autowired
    private VenteRepository venteRepository;
    public Vente save(Vente vente) {
        return venteRepository.save(vente);
    }

    public List<Vente> show() {
        return venteRepository.findAll();
    }
}
