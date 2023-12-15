package com.example.ptmedia.service;

import com.example.ptmedia.model.Rate;
import com.example.ptmedia.repository.RateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RateService {
    private final RateRepository  rateRepository;

    public Rate Register(Rate rate) {
        return rateRepository.save(rate);
    }
}
