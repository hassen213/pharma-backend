package com.example.pharmacie.dto;

import com.example.pharmacie.model.Famille;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor @AllArgsConstructor
public class MedicamentDto {
    private Long id;
    private String name;
    private Double prix;
    private Date dateEx;
    private Famille famille;
}
