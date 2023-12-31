package com.proxym.prospection.backend.auth.services;


import com.proxym.prospection.backend.auth.dao.AuthenticationRequest;
import com.proxym.prospection.backend.auth.dao.AuthenticationResponse;
import com.proxym.prospection.backend.auth.dao.RegisterRequest;
import com.proxym.prospection.backend.auth.security.JwtService;
import com.proxym.prospection.backend.features.DTO.UserRoleDTO;
import com.proxym.prospection.backend.features.user.dao.entities.User;
import com.proxym.prospection.backend.features.user.dao.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new IllegalArgumentException("Password and Confirm Password do not match");
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
            throw new InsufficientAuthenticationException("User must be authenticated to register");
        }
       User  user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .JoiningDate(request.getJoiningDate())
                .role(request.getRole())
                .Departments(request.getDepartments())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .confirmPassword(passwordEncoder.encode(request.getConfirmPassword()))
                .phone(request.getPhone())
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken( user);
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
        User user = repository.findByUsername(request.getUsername());
//                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .role(user.getRole())
                .build();
    }

}
