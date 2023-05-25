package com.proxym.prospection.backend.features.DTO;

import lombok.Data;

import java.sql.Date;

@Data
public class EntrepriseDTO {

    private Long id;

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

    private Number fax;

    private String social;

    private String status;
//    public EntrepriseDTO(Long id) {
//        this.id = id;
//    }
}
