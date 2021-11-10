package com.example.pharmacie.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "prix", nullable = false)
    private Double prix;
    @Column(name = "dateEx", nullable = false)
    private LocalDateTime dateEx;
    @ManyToOne
    private Famille famille;
    @OneToMany(mappedBy = "medicament")
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private Collection<StockMedicament> StockMedicaments;

}
