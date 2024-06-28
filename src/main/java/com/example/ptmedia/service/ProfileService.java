package com.example.ptmedia.service;

import com.example.ptmedia.controller.dto.Profile.ProfileRegisterRequestDto;
import com.example.ptmedia.controller.dto.Profile.ProfileRegisterUpdateDto;
import com.example.ptmedia.controller.dto.Profile.ProfileResponseDto;
import com.example.ptmedia.model.Profile;
import com.example.ptmedia.repository.PostRepository;
import com.example.ptmedia.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final PostRepository postRepository;

    public Profile registerProfile(ProfileRegisterRequestDto profileRegisterRequestDto) {
        Profile profile = new Profile();
        profile.setName(profileRegisterRequestDto.getName());
        profile.setMobile(profileRegisterRequestDto.getMobile());
        return this.profileRepository.save(profile);
    }

    public List<ProfileResponseDto> findAllProfile() {
        return this.profileRepository.findAll(Sort.by("name")).stream().map(prifile -> {
            ProfileResponseDto profileResponseDto = new ProfileResponseDto();
            profileResponseDto.setId(prifile.getId());
            profileResponseDto.setMobile(prifile.getMobile());
            profileResponseDto.setName(prifile.getName());
            return profileResponseDto;
        }).collect(Collectors.toList());
    }

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

    public ProfileResponseDto getById(long id) {

        ProfileResponseDto profileResponseDto = new ProfileResponseDto();
         this.profileRepository.findById(id).ifPresent(profile -> {
            profileResponseDto.setId(profile.getId());
            profileResponseDto.setName(profile.getName());
            profileResponseDto.setMobile(profile.getMobile());
        });

        return profileResponseDto;
    }

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


//    private final DtoMapper dtoMapper;
//    public ProfileDto Register(ProfileRegisterRequestDto request) {
//        if (profileRepository.existsByMobile(request.getMobile())) {
//            throw new AlreadyExistsException("this phone number is already exist");
//        }
//        if (request.getMobile().length() != 11) {
//            throw new ValidationException("phone number is not equal 11 character ");
//        }
//        Profile profile = this.dtoMapper.profile(request);
//        Profile savedProfile = this.profileRepository.save(profile);
//        return this.dtoMapper.profileDto(savedProfile);
//    }
//
//    public Profile getProfile(long id) {
//        try {
//            return profileRepository.findById(id).orElseThrow();
//        } catch (Exception exception) {
//            throw new NotFoundException("user is not exsit");
//        }
//    }
//
//    public List<Profile> getAllProfile() {
//        try {
//            return profileRepository.findAll();
//        } catch (NotFoundException exception) {
//            throw new NotFoundException("no profile found");
//        }
//    }
//
//    public boolean deleteProfile(Long id) {
//        if (profileRepository.existsById(id)) {
//            profileRepository.deleteById(id);
//            return true;
//        }
//        throw new NotFoundException("user is not exsit");
//    }
//
//    public boolean updateProfile(Profile profile) {
//        if (profileRepository.existsById(profile.getId())) {
//            if (!profile.equals(profileRepository.findById(profile.getId()).orElse(null))) {
//
//                throw new ValidationException(" no change detected :( ");
//            }
//            Profile profile1 = profileRepository.findById(profile.getId()).orElseThrow();
//            if (profile.getMobile().length() != 11) {
//                throw new ValidationException("phone number is not equal 11 character ");
//            } else {
//                if (profileRepository.existsByMobile(profile.getMobile())) {
//                    throw new AlreadyExistsException("this phone number is already exists");
//                }
//            }
//            profile1.setMobile(profile.getMobile());
//            profile1.setName(profile.getName());
//            profileRepository.save(profile1);
//            return true;
//        }
//        throw new NotFoundException("user is not exsit");
//    }
//
//    public boolean deleteAll() {
//        try {
//            profileRepository.deleteAll();
//            return true;
//        } catch (Exception exception) {
//            return false;
//        }
//    }

}
