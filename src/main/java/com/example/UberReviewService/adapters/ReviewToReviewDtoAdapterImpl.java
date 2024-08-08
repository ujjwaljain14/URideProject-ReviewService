package com.example.UberReviewService.adapters;

import com.example.UberReviewService.dtos.ReviewDto;
import com.example.UberReviewService.models.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewToReviewDtoAdapterImpl implements ReviewToReviewDtoAdapter {
    @Override
    public ReviewDto convertReviewToReviewDto(Review review) {
        return ReviewDto.builder()
                .id(review.getId())
                .content(review.getContent())
                .booking(review.getBooking().getId())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }
}
