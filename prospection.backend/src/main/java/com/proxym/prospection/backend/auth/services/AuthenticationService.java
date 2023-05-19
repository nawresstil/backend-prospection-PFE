package com.proxym.prospection.backend.auth.services;


import com.proxym.prospection.backend.auth.dao.AuthenticationRequest;
import com.proxym.prospection.backend.auth.dao.AuthenticationResponse;
import com.proxym.prospection.backend.auth.dao.RegisterRequest;
import com.proxym.prospection.backend.auth.security.JwtService;
import com.proxym.prospection.backend.features.user.dao.entities.User;
import com.proxym.prospection.backend.features.user.dao.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private  final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    //this authenticationResponse contains the token
    public AuthenticationResponse register(RegisterRequest request ) {

        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(request.getRole())
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .role(request.getRole())
                .build();
    }

    // if the pswd or email are wrong so an exception would be thrown
    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        // if the credentials are correct then return the token
        User user = repository.findByUsername(request.getUsername())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .role(user.getRole())
                .build();
    }

}
