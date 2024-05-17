package com.example.ptmedia.controller;

import com.example.ptmedia.controller.dto.ProfileRegisterRequestDto;
import com.example.ptmedia.model.Profile;
import com.example.ptmedia.service.ProfileService;
import com.example.ptmedia.service.dto.ProfileDto;
import com.example.ptmedia.util.DtoMapper;
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
    private final DtoMapper dtoMapper;

    @PostMapping("/add")
    public ResponseEntity<ProfileDto> ProfileRegister(@RequestBody ProfileRegisterRequestDto profileRegisterRequestDto) {
        return ResponseEntity.ok(profileService.Register(profileRegisterRequestDto));
    }

    @PostMapping("/get")
    public ResponseEntity<Profile> ProfileGet(@RequestParam long id) {
        return ResponseEntity.ok(profileService.getProfile(id));
    }

    @PostMapping("/getAll")
    public ResponseEntity<List<Profile>> getAll() {
        return ResponseEntity.ok(profileService.getAllProfile());
    }
    @PostMapping("/delete")
    public ResponseEntity<String> ProfileDelete(@RequestParam("id") Long id) {
        if (profileService.deleteProfile(id)) {
            return ResponseEntity.ok(" user is deleted ");
        } else {
            return ResponseEntity.ok(" user is not deleted ");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Boolean> ProfileUpdate(@RequestBody Profile profile) {
        return ResponseEntity.ok(profileService.updateProfile(profile));
    }

    @PostMapping("/deleteAll")
    public ResponseEntity<Boolean> deleteAll() {
        return ResponseEntity.ok(profileService.deleteAll());
    }


}
