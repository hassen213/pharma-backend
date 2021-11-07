package com.example.pharmacie.service;

import com.example.pharmacie.repository.FamilleRepository;
import com.example.pharmacie.dto.FamilleDto;
import com.example.pharmacie.model.Famille;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilleService {

    @Autowired
    private FamilleRepository familleRepository;

    public Famille save(Famille famille) {
        return familleRepository.save(famille);
    }

    public List<Famille> getListFamille() {
        return familleRepository.findAll();
    }

    public Famille updateFamille(Famille famille) {
        if (!isFamilleValid(famille)) {
            throw new IllegalArgumentException();
        }
        return familleRepository.save(famille);
    }

    private boolean isFamilleValid(Famille famille) {
        return famille != null
                && famille.getId() != null
                && familleRepository.existsById(famille.getId());
    }
}
