package com.proxym.prospection.backend.features.action.dao.repositories;

import com.proxym.prospection.backend.features.action.dao.entities.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<Action,Long> {

}