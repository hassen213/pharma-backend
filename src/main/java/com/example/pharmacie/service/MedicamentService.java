package com.example.pharmacie.service;

import com.example.pharmacie.repository.MedicamentRepository;
import com.example.pharmacie.dto.MedicamentDto;
import com.example.pharmacie.model.Medicament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentService {
    @Autowired
    private MedicamentRepository medicamentRepository;

    public Medicament addMedicament(MedicamentDto medicamentDto) {
        Medicament medicament = new Medicament();
        medicament.setName(medicamentDto.getName());
        medicament.setPrix(medicamentDto.getPrix());
        medicament.setDateEx(medicamentDto.getDateEx());
        medicament.setFamille(medicamentDto.getFamille());
        medicamentRepository.save(medicament);
        return medicament;
    }



    public List<Medicament> getListMedicament() {
       return medicamentRepository.findAll();
    }




    public Medicament updateMedicament(Long id, MedicamentDto newMedicament){
        Medicament m ;
        if (medicamentRepository.findById(id).isPresent()) {
            Medicament medicament = new Medicament();
            medicament.setId(id);
            medicament.setName(newMedicament.getName());
            medicament.setPrix(newMedicament.getPrix());
            medicament.setDateEx(newMedicament.getDateEx());
            medicament.setFamille(newMedicament.getFamille());
            m = medicamentRepository.save(medicament);
        }
        else {return null;}
        return m;
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
}
