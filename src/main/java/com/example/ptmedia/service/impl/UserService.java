package com.example.ptmedia.service.impl;

import com.example.ptmedia.dto.Profile.ProfileRegisterRequestDto;
import com.example.ptmedia.dto.Profile.ProfileRegisterUpdateDto;
import com.example.ptmedia.dto.Profile.ProfileResponseDto;
import com.example.ptmedia.entity.User;
import com.example.ptmedia.repository.UserRepository;
import com.example.ptmedia.service.UserInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserInterface {
    private final UserRepository userRepository;

    @Override
    public User registerProfile(ProfileRegisterRequestDto profileRegisterRequestDto) {
        User user = new User();
        user.setName(profileRegisterRequestDto.getName());
        user.setMobile(profileRegisterRequestDto.getMobile());
        return this.userRepository.save(user);
    }

    @Override
    public List<ProfileResponseDto> findAllProfile() {
        return this.userRepository.findAll(Sort.by("name")).stream().map(prifile -> {
            ProfileResponseDto profileResponseDto = new ProfileResponseDto();
            profileResponseDto.setId(prifile.getId());
            profileResponseDto.setMobile(prifile.getMobile());
            profileResponseDto.setName(prifile.getName());
            return profileResponseDto;
        }).collect(Collectors.toList());
    }


    @Override
    public Boolean deleteProfile(Integer id) {
        try {
            this.userRepository.findById(id).ifPresent(profile -> {
                this.userRepository.deleteById(profile.getId());
            });
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public ProfileResponseDto getById(Integer id) {

        ProfileResponseDto profileResponseDto = new ProfileResponseDto();
        this.userRepository.findById(id).ifPresent(user -> {
            profileResponseDto.setId(user.getId());
            profileResponseDto.setName(user.getName());
            profileResponseDto.setMobile(user.getMobile());
        });

        return profileResponseDto;
    }
    @Override
    public ProfileResponseDto getEmail(String email) {

        ProfileResponseDto profileResponseDto = new ProfileResponseDto();
        this.userRepository.findByEmail(email).ifPresent(user -> {
            profileResponseDto.setId(user.getId());
            profileResponseDto.setName(user.getName());
            profileResponseDto.setMobile(user.getMobile());
        });
        return profileResponseDto;
    }

    @Override
    public User updateProfile(Integer id, ProfileRegisterUpdateDto profileRegisterUpdateDto) {
        User profile = this.userRepository.findById(id).orElse(null);
        if (profile != null) {
            if (profileRegisterUpdateDto.getMobile() != null) {
                profile.setMobile(profileRegisterUpdateDto.getMobile());
            }
            if (profileRegisterUpdateDto.getName() != null) {
                profile.setName(profileRegisterUpdateDto.getName());
            }
            return this.userRepository.save(profile);
        }
        return null;
    }

}
