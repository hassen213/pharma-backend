package com.example.pharmacie.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockMedicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne
    private Medicament medicament;

    @ManyToOne
    private Stock stock;

}

//    @OneToMany(mappedBy = "stockMedicament")
//    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
//    private Collection<VenteMedicament> venteMedicaments;
