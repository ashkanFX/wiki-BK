package com.example.ptmedia.controller;

import com.example.ptmedia.entity.Profile;
import com.example.ptmedia.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Profile profile) {
        Profile saveProfile = null;
        ResponseEntity responseEntity = null;
        try {
            String hashPassword = passwordEncoder.encode(profile.getPassword());
            profile.setPassword(hashPassword);
            saveProfile = profileRepository.save(profile);
            if (saveProfile.getId() > 0) {
                responseEntity = ResponseEntity.status(HttpStatus.CREATED).body("user ok shod");
            }
        } catch (Exception exception) {
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("user ok nashod");
        }
        return responseEntity;
    }
    @RequestMapping("/user")
    public Profile getUserDetailsAfterLogin(Authentication authentication) {
        List<Profile> optionalCustomer = profileRepository.findByName(authentication.getName());
        if (optionalCustomer.size() > 0) {
            return optionalCustomer.get(0);
        } else {
            return null;
        }
    }

}
