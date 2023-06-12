package com.proxym.prospection.backend.features.guide.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "guides")

public class GuideProspection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String tracability;

    private String creationDate;

    private String annee;

    private String objectif;

    private String qualification;

    private String description;

    private String suivi;


}
