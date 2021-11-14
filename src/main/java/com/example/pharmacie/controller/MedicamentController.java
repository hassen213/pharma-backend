package com.example.pharmacie.controller;

import com.example.pharmacie.dto.MedicamentDto;
//import com.example.pharmacie.mapper.MedicamentMapper;
import com.example.pharmacie.mapper.MedicamentMapper;
import com.example.pharmacie.model.Medicament;
import com.example.pharmacie.repository.MedicamentRepository;
import com.example.pharmacie.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/medicaments")
public class MedicamentController {
    @Autowired
    private MedicamentService medicamentService;
    @Autowired
    private MedicamentMapper medicamentMapper;

    @PostMapping
    public MedicamentDto addMedic(@RequestBody MedicamentDto medicamentDto){
        Medicament medicament = medicamentMapper.toModel(medicamentDto);
        return medicamentMapper.toDto(medicamentService.addMedic(medicament));
    }
        @GetMapping
    public List<MedicamentDto> getListMedicament(){
//        List<MedicamentDto> medicamentDtos = new ArrayList<>();
//            List<Medicament> listMedicament = medicamentService.getListMedicament();
//            for (int i = 0; i < listMedicament.size(); i++) {
//                medicamentDtos.add(medicamentMapper.toDto(listMedicament.get(i)));
//            }
//            return medicamentDtos;
            return medicamentService.getListMedicament().stream()
                    .map(medicament -> medicamentMapper.toDto(medicament))
                    .collect(Collectors.toList());
    }


//    @Autowired
//    private MedicamentMapper medicamentMapper;
//
//
//    @PostMapping
//    public MedicamentDto addMedicament(@RequestBody MedicamentDto medicamentDto){
//        Medicament medicament = medicamentMapper.toModel(medicamentDto);
//        return medicamentMapper.toDto(medicamentService.addMedicament(medicament));
//    }
//
//    @GetMapping
//    public List<MedicamentDto> getListMedicament(){
//        return medicamentService.getListMedicament().stream()
//                .map(medicamentMapper::toDto)
//                .collect(Collectors.toList());
//    }
//
//
//    @PutMapping
//    public MedicamentDto updateMedicament(@RequestBody MedicamentDto medicamentDto) {
//        Medicament medicament = medicamentMapper.toModel(medicamentDto);
//        return medicamentMapper.toDto(medicamentService.updateMedicament(medicament));
//    }

    @DeleteMapping
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
