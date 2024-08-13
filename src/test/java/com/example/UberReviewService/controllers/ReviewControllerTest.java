package com.example.UberReviewService.controllers;

import com.example.UberReviewService.adapters.CreateReviewDtoToReviewAdapter;
import com.example.UberReviewService.adapters.ReviewToReviewDtoAdapter;
import com.example.UberReviewService.controller.ReviewController;
import com.example.UberReviewService.dtos.ReviewDto;
import com.example.UberReviewService.services.ReviewService;
import com.example.uberprojectentityservice.models.Review;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ReviewControllerTest {

    @InjectMocks
    private ReviewController reviewController;

    @Mock
    private ReviewService reviewService;

    @Mock
    private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;

    @Mock
    private ReviewToReviewDtoAdapter reviewToReviewDtoAdapter;

    @BeforeEach
    public void openMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void releaseMocks() throws Exception {
        MockitoAnnotations.openMocks(this).close();
    }

    @Test
    public void testFindReviewById_Success(){

        long reviewId = 1L;
        Review mockReview = Review.builder().build();
        mockReview.setId(reviewId);

        ReviewDto mockReviewDto = ReviewDto.builder().build();
        mockReviewDto.setId(reviewId);

        when(reviewService.findReviewById(reviewId)).thenReturn(Optional.of(mockReview));
        when(reviewToReviewDtoAdapter.convertReviewToReviewDto(mockReview)).thenReturn(mockReviewDto);

        //perform the test
        ResponseEntity<?> response = reviewController.findReviewById(reviewId);

        //assertions
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(mockReviewDto, response.getBody());

    }

}
