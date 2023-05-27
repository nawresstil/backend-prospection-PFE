package com.proxym.prospection.backend.features.action.dao.entities;

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
    @Table(name = "actions")
    public class Action {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)

        private Long id;

        private String typeAction;

        private String titreAction;

        private String tempsDebut;

        private String tempFin;

        private String collaborateur;

        private String dateDebut;

        private String dateFin;
}
