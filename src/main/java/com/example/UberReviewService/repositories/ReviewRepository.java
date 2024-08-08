package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    Integer countAllByRatingIsLessThanEqual(Integer givenRating);

    List<Review> findAllByRatingIsLessThanEqual(Integer givenRaitng);

    List<Review> findAllByCreatedAtBefore(Date givenCreatedAt);

    @Query("SELECT r from Booking b inner join Review r on b.review = r where b.id = :bookingId")
    Review findReviewByBookingId(Long bookingId);
}
