package com.example.pharmacie.service;

//import com.example.pharmacie.mapper.MedicamentMapper;
import com.example.pharmacie.model.Famille;
import com.example.pharmacie.repository.MedicamentRepository;
import com.example.pharmacie.dto.MedicamentDto;
import com.example.pharmacie.model.Medicament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class MedicamentService {
    @Autowired
    private MedicamentRepository medicamentRepository;

    public Medicament addMedic(Medicament medicament){
        return medicamentRepository.save(medicament);
    }


    public Collection<Medicament> getListMedicament() {
       return medicamentRepository.findAll();
    }

    public Medicament updateMedicament(Medicament medicament){
        if(medicamentRepository.findById(medicament.getId()).isPresent()) {
            return medicamentRepository.save(medicament);}
        else return null;

        }

    public ResponseEntity deleteMedicament(Long id) {
        if(medicamentRepository.findById(id).isPresent()){
            medicamentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public Optional<Medicament> findById(Long medicamentId) {
        return medicamentRepository.findById(medicamentId);
    }
}
