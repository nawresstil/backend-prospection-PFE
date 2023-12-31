package com.proxym.prospection.backend.features.task.dao.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import com.proxym.prospection.backend.features.user.dao.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.sql.Date;
import java.sql.Time;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tacheSociety")
public class TacheS {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String label;
    private String collaborateurs;
    private Date date;
    private String times;
    private String contact;
    private String titre;
    private String description;
    private String etat;
    private String comment;
    private File files;


//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Client client;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Prospect prospect;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private User user;
    @ManyToOne()
    @JsonBackReference(value="user-tacheS")
    private User user;
}
