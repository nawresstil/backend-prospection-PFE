package com.proxym.prospection.backend.features.company.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proxym.prospection.backend.features.project.dao.entities.Projet;
import com.proxym.prospection.backend.features.task.dao.entities.TacheS;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "societies")
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    information of the society
    private Long id;

    private String tracability;
    private String societyName;

    private String siteWeb;

    private Number phoneSociety;

    private Number faxSociety;

    private String emailSociety;

    private String pays;

    private String sector;

    private String nbrEmployee;

    private Date creationDate;

    private Integer priority;

    private String typeSociety;

//Information for the commercial of the society

    private String gender;

    private String firstName;

    private String lastName;

    private String function;

    private String email;

    private Number phone;

    private String social;
    private String status;

//    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE},mappedBy = "entreprise")
    private List<TacheS> tacheS;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE}, mappedBy = "entreprise")
    private List<Projet> projets;
}
