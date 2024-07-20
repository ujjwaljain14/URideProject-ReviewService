package com.example.URideReviewService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Primary;

@Entity
public class Review {
    @Id //this annotation makes the id property as primary key of table
    Long id;

}
