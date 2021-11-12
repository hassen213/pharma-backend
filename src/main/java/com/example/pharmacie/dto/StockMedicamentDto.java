package com.example.pharmacie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockMedicamentDto {
    private Long medicamentId;
    private Long stockId;
    private int quantity;
}
