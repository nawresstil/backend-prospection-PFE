package com.proxym.prospection.backend.auth.controllers;


import com.proxym.prospection.backend.auth.dao.AuthenticationRequest;
import com.proxym.prospection.backend.auth.dao.AuthenticationResponse;
import com.proxym.prospection.backend.auth.dao.RegisterRequest;
import com.proxym.prospection.backend.auth.services.AuthenticationService;
import com.proxym.prospection.backend.features.user.dao.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private User user;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(

            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(

            @RequestBody AuthenticationRequest request
    )

    {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
