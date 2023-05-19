package com.proxym.prospection.backend.features.user.controller;

import com.proxym.prospection.backend.features.user.dao.entities.User;
import com.proxym.prospection.backend.features.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {

        return userService.getAllUsers();
    }
    @GetMapping("/first/{firstname}")
    public ResponseEntity<User> getUserByFirstname(@PathVariable String firstname)
    {
        return userService.getUserByFirstname(firstname);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User userDetails) {

        return userService.updateUser(id , userDetails);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {

        return userService.deleteUser(id);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<User> forgotPassword(@RequestBody Map<String, String> requestMap) {
        return userService.forgotPassword(requestMap);
    }
}
