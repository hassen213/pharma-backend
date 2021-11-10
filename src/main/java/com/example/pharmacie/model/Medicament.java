package com.example.pharmacie.model;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
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
    private Date dateEx;
    @ManyToOne
    private Famille famille;

}
