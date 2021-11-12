package com.example.pharmacie.mapper;

import com.example.pharmacie.dto.MedicamentDto;
import com.example.pharmacie.dto.VenteDto;
import com.example.pharmacie.model.Medicament;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface MedicamentMapper {
    Medicament toModel(MedicamentDto medicamentDto);
    @Mappings({
            @Mapping(target = "familleId", source = "famille.id"),
            @Mapping(target = "familleName", source = "famille.name")

    })

    MedicamentDto toDto(Medicament medicament);

    @AfterMapping
    default void afterMapping(MedicamentDto dto, @MappingTarget Medicament model){
        if(dto.getFamilleId() != null){
            model.setFamille(
                    DependencyResolver.instance.familleById(dto.getFamilleId()));
        } else {
            throw new IllegalArgumentException("Famille must not be null");
        }
    }



}


//@Mapper(componentModel = "spring")
//public interface MedicamentMapper {
//    Medicament toModel(MedicamentDto dto);
//    @Mappings({
//            @Mapping(target = "familleId", source = "famille.id"),
//            @Mapping(target = "familleName", source = "famille.name"),
//    })
//    MedicamentDto toDto(Medicament model);
//
//    @AfterMapping
//    default void afterMapping(MedicamentDto dto, @MappingTarget Medicament model) {
//        if (dto.getFamilleId() != null) {
//            model.setFamille(
//                    DependencyResolver.instance
//                            .familleById(dto.getFamilleId()));
//        } else {
//            throw new IllegalArgumentException("Famille must not be null");
//        }
//    }
//}
