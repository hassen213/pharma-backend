package com.example.pharmacie.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VenteMedicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vente vente;

    @ManyToOne
    private StockMedicament stockMedicament;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vente getVente() {
        return vente;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
    }

    public StockMedicament getStockMedicament() {
        return stockMedicament;
    }

    public void setStockMedicament(StockMedicament stockMedicament) {
        this.stockMedicament = stockMedicament;
    }
}
