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
public class Vente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateDeVente;

    @OneToMany(mappedBy = "vente")
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private Collection<VenteMedicament> venteMedicaments;

    public Vente() {
    }

    public Vente(Long id, LocalDateTime dateDeVente, Collection<VenteMedicament> venteMedicaments) {
        this.id = id;
        this.dateDeVente = dateDeVente;
        this.venteMedicaments = venteMedicaments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateDeVente() {
        return dateDeVente;
    }

    public void setDateDeVente(LocalDateTime dateDeVente) {
        this.dateDeVente = dateDeVente;
    }

    public Collection<VenteMedicament> getVenteMedicaments() {
        return venteMedicaments;
    }

    public void setVenteMedicaments(Collection<VenteMedicament> venteMedicaments) {
        this.venteMedicaments = venteMedicaments;
    }
}
