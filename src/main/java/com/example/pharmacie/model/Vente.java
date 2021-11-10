package com.example.pharmacie.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateDeVente;

    @OneToMany(mappedBy = "vente")
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private Collection<VenteMedicament> venteMedicaments;

}
