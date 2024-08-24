package com.example.ptmedia.controller;

import com.example.ptmedia.dto.Profile.ProfileRegisterRequestDto;
import com.example.ptmedia.dto.Profile.ProfileRegisterUpdateDto;
import com.example.ptmedia.dto.Profile.ProfileResponseDto;
import com.example.ptmedia.entity.User;
import com.example.ptmedia.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> registerProfile(@RequestBody ProfileRegisterRequestDto profileRegisterRequestDto) {
        return ResponseEntity.ok(this.userService.registerProfile(profileRegisterRequestDto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProfileResponseDto>> getAllProfile() {
        return ResponseEntity.ok(this.userService.findAllProfile());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteUser(@RequestParam Integer id) {
        return ResponseEntity.ok(this.userService.deleteProfile(id));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProfileResponseDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.userService.getById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody ProfileRegisterUpdateDto profileRegisterUpdateDto) {
        return ResponseEntity.ok(this.userService.updateProfile(id, profileRegisterUpdateDto));

    }

}
