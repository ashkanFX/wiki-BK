package com.example.ptmedia.service;

import com.example.ptmedia.dto.Rate.RateRequestDto;
import com.example.ptmedia.entity.Rate;

public interface RateInterface {
    Rate Register(RateRequestDto rateRequestDto);
}
