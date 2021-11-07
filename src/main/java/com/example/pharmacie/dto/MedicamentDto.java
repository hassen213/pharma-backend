package com.example.pharmacie.dto;

import com.example.pharmacie.model.Famille;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class MedicamentDto {
    private String name;
    private Double prix;
    private Date dateEx;
    private Famille famille;
}
