package com.proxym.prospection.backend.features.user.service.impl;


import com.proxym.prospection.backend.features.user.dao.entities.User;
import com.proxym.prospection.backend.features.user.dao.repositories.UserRepository;
import com.proxym.prospection.backend.features.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    @Override
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> user = userRepository.findAll();

        return ResponseEntity.ok().body(user);

    }

    @Override
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(user);
    }

    @Override
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        // Check if the new password is provided and validate the old password
        if (userDetails.getPassword() != null) {
            if (userDetails.getOldPassword() == null || !passwordEncoder.matches(userDetails.getOldPassword(), user.getPassword())) {
                return ResponseEntity.badRequest().build();
            }
        }

        user.setUsername(userDetails.getUsername());

        if (userDetails.getPassword() != null && userDetails.getConfirmPassword() != null) {
            // Check if the new password and confirmed new password match
            if (!userDetails.getPassword().equals(userDetails.getConfirmPassword())) {
                return ResponseEntity.badRequest().build();
            }

            String encryptedPassword = passwordEncoder.encode(userDetails.getPassword());
            user.setPassword(encryptedPassword);
        }

        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        user.setUsername(userDetails.getUsername());
/*
//        user.setPhone(userDetails.getPhone());
*/
        user.setOldPassword(passwordEncoder.encode(userDetails.getOldPassword()));
        user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        user.setConfirmPassword(passwordEncoder.encode(userDetails.getConfirmPassword()));
        user.setRole(userDetails.getRole());

        User updatedUser = userRepository.save(user);

        return ResponseEntity.ok(updatedUser);
    }
    @Override
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<User> forgotPassword(Map<String, String> requestMap) {
        try {
            String email = requestMap.get("email");
            User user = userRepository.findByEmail(email);

            if (user == null) {
                // User not found
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            // Generate and save a new password for the user
            String newPassword = generateNewPassword();
            String encodedPassword = passwordEncoder.encode(newPassword); // Encode the password
            user.setPassword(encodedPassword);

            userRepository.save(user);

            // Send the new password to the user (you can customize this part based on your requirements)
/*
            sendPasswordByEmail(user.getEmail(), newPassword);
*/

            return ResponseEntity.ok(user);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Override
    public ResponseEntity<User> getUserByFirstname(@PathVariable String firstname) {
        User user = userRepository.findUserByFirstname(firstname);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    // Method to generate a new password (you can customize this method based on your requirements)
    private String generateNewPassword() {
        // Generate a random password or implement your own logic
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int length = 10;
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * allowedChars.length());
            password.append(allowedChars.charAt(randomIndex));
        }

        return password.toString();
    }
/*    @Autowired
    private JavaMailSender javaMailSender;
    // Method to send the new password to the user (you can customize this method based on your requirements)
    private void sendPasswordByEmail(String email, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("nawresstilouch1@gmail.com");
        message.setTo(email);
        message.setSubject("Password Reset");
        message.setText("Your new password is: "+ password);

        javaMailSender.send(message);
    }*/
}
