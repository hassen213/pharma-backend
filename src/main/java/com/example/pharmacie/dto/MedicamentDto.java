package com.example.pharmacie.dto;

import com.example.pharmacie.model.Famille;
import com.example.pharmacie.model.Stock;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor @AllArgsConstructor
public class MedicamentDto {
    private Long id;
    private String name;
    private Double prix;
    private LocalDateTime dateEx;
    private String familleName;
    private Long familleId;


}
