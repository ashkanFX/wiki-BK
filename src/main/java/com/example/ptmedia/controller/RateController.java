package com.example.ptmedia.controller;

import com.example.ptmedia.dto.Rate.RateRequestDto;
import com.example.ptmedia.entity.Rate;
import com.example.ptmedia.service.impl.RateService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rate")
@AllArgsConstructor
public class RateController {
    private final RateService rateService;

    @PostMapping("/add")
    public ResponseEntity<Rate> postRegister(@RequestBody RateRequestDto rateRequestDto) {
        return ResponseEntity.ok(rateService.Register(rateRequestDto));
    }
}