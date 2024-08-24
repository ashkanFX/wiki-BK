package com.example.ptmedia.service;

import com.example.ptmedia.dto.Profile.ProfileRegisterRequestDto;
import com.example.ptmedia.dto.Profile.ProfileRegisterUpdateDto;
import com.example.ptmedia.dto.Profile.ProfileResponseDto;
import com.example.ptmedia.entity.User;

import java.util.List;

public interface UserInterface {
    User registerProfile(ProfileRegisterRequestDto profileRegisterRequestDto);

    List<ProfileResponseDto> findAllProfile();

    Boolean deleteProfile(Integer id);

    ProfileResponseDto getById(Integer id);

    User updateProfile(Integer id, ProfileRegisterUpdateDto profileRegisterUpdateDto);
}
