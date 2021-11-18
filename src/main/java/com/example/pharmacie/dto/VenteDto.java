package com.example.pharmacie.dto;

import com.example.pharmacie.model.Medicament;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenteDto {

    private Long id;
    private LocalDateTime dateDeVente;
    private Long medId;
    private Long stockId;
    private int quantity;

}
