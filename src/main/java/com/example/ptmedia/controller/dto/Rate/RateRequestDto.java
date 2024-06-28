package com.example.ptmedia.controller.dto.Rate;

import lombok.Data;

@Data
public class RateRequestDto {
    private Long postId;
    private Long profileId;
    private int rate;
}
