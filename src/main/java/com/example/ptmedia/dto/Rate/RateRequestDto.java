package com.example.ptmedia.dto.Rate;

import lombok.Data;

@Data
public class RateRequestDto {
    private Long postId;
    private Long profileId;
    private int rate;
}
