package com.example.pharmacie.mapper;

import com.example.pharmacie.dto.StockDto;
import com.example.pharmacie.model.Stock;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StockMapper {
    StockDto toDto(Stock stock);
    Stock toModel(StockDto stockDto);
}
