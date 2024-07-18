package com.example.ptmedia.service;

import com.example.ptmedia.dto.Rate.RateRequestDto;
import com.example.ptmedia.model.Rate;
import com.example.ptmedia.repository.PostRepository;
import com.example.ptmedia.repository.ProfileRepository;
import com.example.ptmedia.repository.RateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RateService {
    private final RateRepository rateRepository;
    private final ProfileRepository profileRepository;
    private final PostRepository postRepository;

    public Rate Register(RateRequestDto rateRequestDto) {
        Rate rate = new Rate();
        rate.setProfile(this.profileRepository.findById(rateRequestDto.getProfileId()).orElse(null));
        rate.setPost(this.postRepository.findById(rateRequestDto.getPostId()).orElse(null));
        rate.setValue(rateRequestDto.getRate());
        return rateRepository.save(rate);
    }
}
