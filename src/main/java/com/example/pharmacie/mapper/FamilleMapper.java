package com.example.pharmacie.mapper;

import com.example.pharmacie.dto.FamilleDto;
import com.example.pharmacie.model.Famille;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FamilleMapper {
    FamilleDto toDto(Famille model);
    Famille toModel(FamilleDto dto);
}
