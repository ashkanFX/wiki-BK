package com.example.ptmedia.controller;

import com.example.ptmedia.controller.dto.ProfileGetDto;
import com.example.ptmedia.controller.dto.ProfileRegisterRequestDto;
import com.example.ptmedia.controller.dto.ProfileRegisterUpdateDto;
import com.example.ptmedia.model.Profile;
import com.example.ptmedia.service.ProfileService;
import com.example.ptmedia.service.dto.ProfileDto;
import com.example.ptmedia.service.dto.ProfilePostDTO;
import com.example.ptmedia.util.DtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;
    private final DtoMapper dtoMapper;

    @PostMapping("/add")
    public ResponseEntity<ProfileDto> ProfileRegister(@RequestBody ProfileRegisterRequestDto profileRegisterRequestDto) {

        return ResponseEntity.ok(profileService.Register(profileRegisterRequestDto));
    }
    @PostMapping("/get")
    public ResponseEntity<Profile> ProfileGet(@RequestBody ProfileGetDto ProfileGetDto) {
        return ResponseEntity.ok(profileService.getProfile(ProfileGetDto));
    }
    @PostMapping("/getAll")
    public ResponseEntity<List<Profile>> getAll() {
        return ResponseEntity.ok(profileService.getAllProfile());
    }

    @PostMapping("/delete")
    public ResponseEntity<Boolean> ProfileDelete(@RequestBody ProfileGetDto profile) {
        return ResponseEntity.ok(profileService.deleteProfile(profile.getId()));
    }

    @PostMapping("/update")
    public ResponseEntity<Boolean> ProfileUpdate(@RequestBody ProfileRegisterUpdateDto profile) {
        return ResponseEntity.ok(profileService.updateProfile(profile));
    }

    @PostMapping("/test")
    public ResponseEntity<List<String>> ProfileUpdate() {
        return ResponseEntity.ok(profileService.getName());
    }


    @PostMapping("/test1")
    public ResponseEntity<List<ProfilePostDTO>> result() {
        return ResponseEntity.ok(profileService.selectPostProfile());
    }

}
