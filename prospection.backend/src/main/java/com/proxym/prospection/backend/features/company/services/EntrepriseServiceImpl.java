package com.proxym.prospection.backend.features.company.services;

import com.proxym.prospection.backend.features.company.dao.entities.Entreprise;
import com.proxym.prospection.backend.features.company.dao.repositories.EntrepriseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EntrepriseServiceImpl implements EntrepriseService{
    private final EntrepriseRepository entrepriseRepository;

    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {

        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public ResponseEntity<List<Entreprise>> getAllEntreprises() {

        List<Entreprise> entreprise = entrepriseRepository.findAll();


        return ResponseEntity.ok().body(entreprise);
    }

    @Override
    public Entreprise createEntreprise(@RequestBody Entreprise entreprise) {
//        entreprise.setTacheS(new HashSet<TacheS>() {}); //when create entreprise add id tacheS
        System.out.println("ssssssssssssssssssssssssssssss"+entreprise);
    return entrepriseRepository.save(entreprise);
    }

    @Override
    public ResponseEntity<Entreprise> getEntrepriseById(@PathVariable Long id) {
        Entreprise entreprise = entrepriseRepository.findById(id).orElse(null);

        if (entreprise == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(entreprise);
    }
    @Override
    public ResponseEntity<Entreprise> getEntrepriseByName(@PathVariable String societyName) {
        Entreprise entreprise = entrepriseRepository.findSocietyBySocietyName(societyName);

        if (entreprise == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(entreprise);
    }
//
    @Override
    public ResponseEntity<Entreprise> updateEntreprise(@PathVariable Long id, @RequestBody Entreprise entrepriseDetails) {
        Entreprise entreprise = entrepriseRepository.findById(id).orElse(null);

        if (entreprise == null) {
            return ResponseEntity.notFound().build();
        }
        entreprise.setSocietyName(entrepriseDetails.getSocietyName());
        entreprise.setSiteWeb(entrepriseDetails.getSiteWeb());
        entreprise.setPhoneSociety(entrepriseDetails.getPhoneSociety());
        entreprise.setFaxSociety(entrepriseDetails.getFaxSociety());
        entreprise.setEmailSociety(entrepriseDetails.getEmailSociety());
        entreprise.setPays(entrepriseDetails.getPays());
        entreprise.setSector(entrepriseDetails.getSector());
        entreprise.setNbrEmployee(entrepriseDetails.getNbrEmployee());
        entreprise.setPriority(entrepriseDetails.getPriority());
        entreprise.setTypeSociety(entrepriseDetails.getTypeSociety());
        entreprise.setSocial(entrepriseDetails.getSocial());

        entreprise.setGender(entrepriseDetails.getGender());
        entreprise.setLastName(entrepriseDetails.getLastName());
        entreprise.setFirstName(entrepriseDetails.getFirstName());
        entreprise.setFunction(entrepriseDetails.getFunction());
        entreprise.setEmail(entrepriseDetails.getEmail());
        entreprise.setPhone(entrepriseDetails.getPhone());
        entreprise.setFax(entrepriseDetails.getFax());
        entreprise.setImageUrl(entrepriseDetails.getImageUrl());
        entreprise.setStatus(entrepriseDetails.getStatus());

        Entreprise updateEntreprise = entrepriseRepository.save(entreprise);

        return ResponseEntity.ok(updateEntreprise);
    }


    public ResponseEntity<Entreprise> deleteEntreprise(@PathVariable Long id) {
        Entreprise entreprise = entrepriseRepository.findById(id).orElse(null);

        if (entreprise == null) {
            return ResponseEntity.notFound().build();
        }
        entrepriseRepository.delete(entreprise);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<Entreprise> findAllEnteprises() {
        return entrepriseRepository.findAll();
    }
    @Override
    public Page<Entreprise> findEntreprisesWithPagination(int offset, int pageSize) {
        Page<Entreprise> entreprises = entrepriseRepository.findAll(PageRequest.of(offset,pageSize));
        return entreprises;
    }
    @Override
    public Page<Entreprise> findEntreprisesWithPaginationAndSorting(int offset,int pageSize,String field) {
        Page<Entreprise> entreprises = entrepriseRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by(field)));
        return entreprises;
    }

    @Override
    public List<Entreprise> findEntreprisesWithSorting(@PathVariable String field){
        return entrepriseRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

}
