package com.example.ptmedia.controller;

import com.example.ptmedia.dto.Profile.ProfileRegisterRequestDto;
import com.example.ptmedia.dto.Profile.ProfileRegisterUpdateDto;
import com.example.ptmedia.dto.Profile.ProfileResponseDto;
import com.example.ptmedia.entity.Profile;
import com.example.ptmedia.service.impl.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
@CrossOrigin
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping("/add")
    public ResponseEntity<Profile> registerProfile(@RequestBody ProfileRegisterRequestDto profileRegisterRequestDto) {
        return ResponseEntity.ok(this.profileService.registerProfile(profileRegisterRequestDto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProfileResponseDto>> getAllProfile() {
        return ResponseEntity.ok(this.profileService.findAllProfile());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteProfile(@RequestParam Long id) {
        return ResponseEntity.ok(this.profileService.deleteProfile(id));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProfileResponseDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(this.profileService.getById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable long id, @RequestBody ProfileRegisterUpdateDto profileRegisterUpdateDto) {
        return ResponseEntity.ok(this.profileService.updateProfile(id, profileRegisterUpdateDto));

    }

}
