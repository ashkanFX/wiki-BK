package com.example.ptmedia.service;

import com.example.ptmedia.controller.dto.ProfileRegisterRequestDto;
import com.example.ptmedia.exception.AlreadyExistsException;
import com.example.ptmedia.exception.NotFoundException;
import com.example.ptmedia.exception.ValidationException;
import com.example.ptmedia.model.Profile;
import com.example.ptmedia.repository.ProfileRepository;
import com.example.ptmedia.service.dto.ProfileDto;
import com.example.ptmedia.util.DtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final DtoMapper dtoMapper;
    public ProfileDto Register(ProfileRegisterRequestDto request) {
        if (profileRepository.existsByMobile(request.getMobile())) {
            throw new AlreadyExistsException("this phone number is already exist");
        }
        if (request.getMobile().length() != 11) {
            throw new ValidationException("phone number is not equal 11 character ");
        }
        Profile profile = this.dtoMapper.profile(request);
        Profile savedProfile = this.profileRepository.save(profile);
        return this.dtoMapper.profileDto(savedProfile);
    }

    public Profile getProfile(long id) {
        try {
            return profileRepository.findById(id).orElseThrow();
        } catch (Exception exception) {
            throw new NotFoundException("user is not exsit");
        }
    }

    public List<Profile> getAllProfile() {
        try {
            return profileRepository.findAll();
        } catch (NotFoundException exception) {
            throw new NotFoundException("no profile found");
        }
    }

    public boolean deleteProfile(Long id) {
        if (profileRepository.existsById(id)) {
            profileRepository.deleteById(id);
            return true;
        }
        throw new NotFoundException("user is not exsit");
    }

    public boolean updateProfile(Profile profile) {
        if (profileRepository.existsById(profile.getId())) {
            if (!profile.equals(profileRepository.findById(profile.getId()).orElse(null))) {

                throw new ValidationException(" no change detected :( ");
            }
            Profile profile1 = profileRepository.findById(profile.getId()).orElseThrow();
            if (profile.getMobile().length() != 11) {
                throw new ValidationException("phone number is not equal 11 character ");
            } else {
                if (profileRepository.existsByMobile(profile.getMobile())) {
                    throw new AlreadyExistsException("this phone number is already exists");
                }
            }
            profile1.setMobile(profile.getMobile());
            profile1.setName(profile.getName());
            profileRepository.save(profile1);
            return true;
        }
        throw new NotFoundException("user is not exsit");
    }

    public boolean deleteAll() {
        try {
            profileRepository.deleteAll();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

}
