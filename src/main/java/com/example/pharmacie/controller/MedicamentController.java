package com.example.pharmacie.controller;

import com.example.pharmacie.dto.MedicamentDto;
import com.example.pharmacie.model.Medicament;
import com.example.pharmacie.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/medicaments")
public class MedicamentController {
    @Autowired
    private MedicamentService medicamentService;

    @PostMapping
    public Medicament addMedicament(@RequestBody MedicamentDto medicamentDto){
        return medicamentService.addMedicament(medicamentDto);
    }

    @GetMapping
    public List<Medicament> getListMedicament(){
        return medicamentService.getListMedicament();
    }


    @PutMapping("/update/{id}")
    public Medicament updateMedicament(@PathVariable Long id, @RequestBody MedicamentDto newMedicament) {
           return medicamentService.updateMedicament(id, newMedicament);


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMedicament(@PathVariable Long id){
        medicamentService.deleteMedicament(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}




//    public Medicament updateMedicament(@PathVariable Long id, @RequestBody MedicamentDto newMedicament) {
//        return medicamentRepository.findById(id)
//                .map(medicament -> {
//                    medicament.setName(newMedicament.getName());
//                    medicament.setPrix(newMedicament.getPrix());
//                    medicament.setDateEx(newMedicament.getDateEx());
//                    return medicamentRepository.save(newMedicament);
//                });
// 4i .orElseGet() chenhi vaydethe
//                .orElseGet(() -> {
//                    newMedicament.setId(id);
//                    return medicamentRepository.save(newMedicament);
//                });
//}
