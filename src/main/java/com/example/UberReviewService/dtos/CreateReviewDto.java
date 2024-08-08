package com.example.UberReviewService.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;


@Getter
@Setter
public class CreateReviewDto{
    private Long bookingId;
    private String content;
    private Double rating;
}