package com.example.ptmedia.service.impl;

import com.example.ptmedia.dto.Profile.ProfileRegisterRequestDto;
import com.example.ptmedia.dto.Profile.ProfileRegisterUpdateDto;
import com.example.ptmedia.dto.Profile.ProfileResponseDto;
import com.example.ptmedia.entity.Profile;
import com.example.ptmedia.repository.PostRepository;
import com.example.ptmedia.repository.ProfileRepository;
import com.example.ptmedia.service.ProfileInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileService implements ProfileInterface {
    private final ProfileRepository profileRepository;

    @Override
    public Profile registerProfile(ProfileRegisterRequestDto profileRegisterRequestDto) {
        Profile profile = new Profile();
        profile.setName(profileRegisterRequestDto.getName());
        profile.setMobile(profileRegisterRequestDto.getMobile());
        return this.profileRepository.save(profile);
    }

    @Override
    public List<ProfileResponseDto> findAllProfile() {
        return this.profileRepository.findAll(Sort.by("name")).stream().map(prifile -> {
            ProfileResponseDto profileResponseDto = new ProfileResponseDto();
            profileResponseDto.setId(prifile.getId());
            profileResponseDto.setMobile(prifile.getMobile());
            profileResponseDto.setName(prifile.getName());
            return profileResponseDto;
        }).collect(Collectors.toList());
    }


    @Override
    public Boolean deleteProfile(Long id) {
        try {
            this.profileRepository.findById(id).ifPresent(profile -> {
                this.profileRepository.deleteById(profile.getId());
            });
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public ProfileResponseDto getById(long id) {

        ProfileResponseDto profileResponseDto = new ProfileResponseDto();
        this.profileRepository.findById(id).ifPresent(profile -> {
            profileResponseDto.setId(profile.getId());
            profileResponseDto.setName(profile.getName());
            profileResponseDto.setMobile(profile.getMobile());
        });

        return profileResponseDto;
    }

    @Override
    public Profile updateProfile(Long id, ProfileRegisterUpdateDto profileRegisterUpdateDto) {
        Profile profile = this.profileRepository.findById(id).orElse(null);
        if (profile != null) {
            if (profileRegisterUpdateDto.getMobile() != null) {
                profile.setMobile(profileRegisterUpdateDto.getMobile());
            }
            if (profileRegisterUpdateDto.getName() != null) {
                profile.setName(profileRegisterUpdateDto.getName());
            }
            return this.profileRepository.save(profile);
        }
        return null;
    }

}
