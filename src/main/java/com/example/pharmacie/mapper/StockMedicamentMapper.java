package com.example.pharmacie.mapper;

import com.example.pharmacie.dto.StockMedicamentDto;
import com.example.pharmacie.model.StockMedicament;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StockMedicamentMapper {
    StockMedicament toModel(StockMedicamentDto stockMedicamentDto);

    @Mappings({
            @Mapping(target = "medicamentId", source = "medicament.id"),
            @Mapping(target = "stockId", source = "stock.id")
    })
    StockMedicamentDto toDto(StockMedicament stockMedicament);
}
