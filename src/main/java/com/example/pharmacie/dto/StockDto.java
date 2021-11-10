package com.example.pharmacie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {

    private int id;
    private int quantiteMedicament;
}
