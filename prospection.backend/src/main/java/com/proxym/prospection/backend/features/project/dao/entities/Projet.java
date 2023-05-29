package com.proxym.prospection.backend.features.project.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projets")

public class Projet {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String societName;

    private Integer nbrEmployee;

    private String date_debut;

    private String date_fin;

    private Integer budget;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;
}
