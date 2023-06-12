package com.proxym.prospection.backend.features.action.dao.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import com.proxym.prospection.backend.features.user.dao.entities.User;
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

        private String tracability;


        private String typeAction;

        private String titreAction;

        private String tempsDebut;

        private String tempFin;

        private String collaborateur;

        private String dateDebut;

        private String dateFin;

        private String etat;

//        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//        private User user;

        @ManyToOne()
        @JsonBackReference(value="user-action")
        private User user;
}
