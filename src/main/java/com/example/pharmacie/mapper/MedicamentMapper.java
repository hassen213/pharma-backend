package com.example.pharmacie.mapper;

import com.example.pharmacie.dto.MedicamentDto;
import com.example.pharmacie.model.Medicament;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicamentMapper {
    Medicament toModel(MedicamentDto medicamentDto);
    MedicamentDto toDto(Medicament medicament);
}
