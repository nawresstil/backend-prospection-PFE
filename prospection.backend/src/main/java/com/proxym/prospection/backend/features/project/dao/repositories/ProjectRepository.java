package com.proxym.prospection.backend.features.project.dao.repositories;

import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import com.proxym.prospection.backend.features.project.dao.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Projet,Long> {
    @Override
    Optional<Projet> findById(Long aLong);
    List<Projet> findByEntreprise(Entreprise entreprise);

}
