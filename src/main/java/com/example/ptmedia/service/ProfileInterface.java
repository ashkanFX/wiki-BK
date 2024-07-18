package com.example.ptmedia.service;

import com.example.ptmedia.dto.Profile.ProfileRegisterRequestDto;
import com.example.ptmedia.dto.Profile.ProfileRegisterUpdateDto;
import com.example.ptmedia.dto.Profile.ProfileResponseDto;
import com.example.ptmedia.entity.Profile;

import java.util.List;

public interface ProfileInterface {
    Profile registerProfile(ProfileRegisterRequestDto profileRegisterRequestDto);

    List<ProfileResponseDto> findAllProfile();

    Boolean deleteProfile(Long id);

    ProfileResponseDto getById(long id);

    Profile updateProfile(Long id, ProfileRegisterUpdateDto profileRegisterUpdateDto);
}
