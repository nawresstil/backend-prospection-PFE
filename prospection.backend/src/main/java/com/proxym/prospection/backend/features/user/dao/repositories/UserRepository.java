package com.proxym.prospection.backend.features.user.dao.repositories;

import com.proxym.prospection.backend.features.user.dao.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findUserByFirstname(String name);
}
