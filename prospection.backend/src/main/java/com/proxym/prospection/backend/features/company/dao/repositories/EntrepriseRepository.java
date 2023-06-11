package com.proxym.prospection.backend.features.company.dao.repositories;

import com.proxym.prospection.backend.features.DTO.CountSocieties;
import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise,Long> {

//    Entreprise findEntrepriseByName(String name);
    @Query("SELECT E FROM Entreprise E WHERE E.status = 'client'")
    List<Entreprise> findClient();

    @Query("SELECT E FROM Entreprise E WHERE E.status = 'prospect'")
    List<Entreprise> findProspect();
    Entreprise findSocietyBySocietyName(String name);

    @Query(value = "SELECT NEW com.proxym.prospection.backend.features.DTO.CountSocieties(COUNT(*)/(SELECT COUNT(*) FROM  Entreprise) * 100, status ) FROM Entreprise GROUP BY status")
    public List<CountSocieties> getPercentageGroupByStatus();
}