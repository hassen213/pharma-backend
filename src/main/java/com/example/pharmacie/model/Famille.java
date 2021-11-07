package com.example.pharmacie.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Famille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "famille")
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private Collection<Medicament> medicaments;


}
