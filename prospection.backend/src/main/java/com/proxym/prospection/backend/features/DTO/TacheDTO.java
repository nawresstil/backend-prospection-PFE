package com.proxym.prospection.backend.features.DTO;

import lombok.Data;

import java.io.File;
import java.sql.Date;
import java.sql.Time;

@Data
public class TacheDTO {

    private String label;
    private String collaborateurs;
    private Date date;
    private Time times;
    private String contact;
    private String titre;
    private String description;
    private String etat;
    private File files;

}
