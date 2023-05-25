package com.proxym.prospection.backend.features.user.service;

import com.proxym.prospection.backend.features.user.dao.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface UserService {
    ResponseEntity<List<User>> getAllUsers();
    User getUserByUsername(String username);

    ResponseEntity<User> getUserById(@PathVariable Long id);

    ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails);

    ResponseEntity<User> deleteUser(@PathVariable Long id);

    ResponseEntity<User> forgotPassword(Map<String, String> requestMap);

    ResponseEntity<User> getUserByFirstname(@PathVariable String firstname);
}