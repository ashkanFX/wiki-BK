package com.example.ptmedia.service;

import com.example.ptmedia.controller.dto.ProfileGetDto;
import com.example.ptmedia.controller.dto.ProfileRegisterRequestDto;
import com.example.ptmedia.controller.dto.ProfileRegisterUpdateDto;
import com.example.ptmedia.exception.AlreadyExistsException;
import com.example.ptmedia.exception.ValidationٍException;
import com.example.ptmedia.model.Profile;
import com.example.ptmedia.repository.ProfileRepository;
import com.example.ptmedia.service.dto.ProfileDto;
import com.example.ptmedia.service.dto.ProfilePostDTO;
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
        if (request.getMobile().length()  != 11){
            throw new ValidationٍException("phone number is not equal 11 character ");
        }
        String s =request.getMobile();
        System.out.println(s.charAt(1));

        Profile profile = this.dtoMapper.profile(request);
        Profile savedProfile = this.profileRepository.save(profile);
        return this.dtoMapper.profileDto(savedProfile);
    }

//    public Profile getProfile(ProfileGetDto ProfileGetDto)  {

//        return this.profileRepository.findById(ProfileGetDto.getId()).orElseThrow(NotFoundException::new);
//         this.dtoMapper.profileDto(getProfile);
//        rofile getProfile = this.profileRepository.findById(ProfileGetDto.getId()).orElseThrow(NotFoundException::new);
//        return this.dtoMapper.profileDto(getProfile);
//    }


    public boolean deleteProfile(Long id) {
//        Profile getProfile = this.profileRepository.findById(id).orElseThrow(alreadyExsitException::new);
//        profileRepository.deleteById(getProfile.getId());
        return true;
    }

    public boolean updateProfile(ProfileRegisterUpdateDto profile) {
//        Profile getProfile = profileRepository.findById(profile.getId()).orElseThrow(alreadyExsitException::new);
//        getProfile.setName(profile.getName());
//        if (profile.getMobile() != null) {
//            getProfile.setMobile(profile.getMobile());
//        }
//        profileRepository.save(getProfile);
        return true;
    }

    public List<Profile> getAllProfile() {
        return this.profileRepository.findAll();
    }
    public List<String> getName(){
        return this.profileRepository.GetProfileName();
    }
    public  List<ProfilePostDTO>  selectPostProfile() {
        return this.profileRepository.getPostDetails();
    }
}
