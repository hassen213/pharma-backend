package com.example.pharmacie.mapper;

import com.example.pharmacie.dto.VenteDto;
import com.example.pharmacie.model.Vente;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VenteMapper {

    Vente toModel(VenteDto venteDto);
    VenteDto toDto(Vente vente);

    @AfterMapping
    default void resolveMedicaments(VenteDto dto, @MappingTarget Vente vente) {
        vente.setMedicaments(
                DependencyResolver.instance
                        .resolveByIds(dto.getMedicamentIds()));
    }
}
