package com.example.URideReviewService.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
public class Review {
    @Id //this annotation makes the id property as primary key of table
    @GeneratedValue(strategy = GenerationType.IDENTITY)//identity means auto increment
    Long id;

    @Column(nullable = false)
    String content;

    Double rating;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // this tells spring about format of date to store in object
    @CreatedDate // this tells spring to only handle it for object creation
    Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate// this tells spring to handle it for object update
    Date updatedAt;
}
