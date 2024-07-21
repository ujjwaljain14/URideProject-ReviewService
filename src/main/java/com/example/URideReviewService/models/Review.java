package com.example.URideReviewService.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="bookingreview")
public class Review {
    @Id //this annotation makes the id property as primary key of table
    @GeneratedValue(strategy = GenerationType.IDENTITY)//identity means auto increment
    private Long id;

    @Column(nullable = false)
    private String content;

    private Double rating;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // this tells spring about format of date to store in object
    @CreatedDate // this tells spring to only handle it for object creation
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate// this tells spring to handle it for object update
    private Date updatedAt;

    @Override
    public String toString(){
        return "Review"+this.content+" "+this.rating+" "+this.createdAt;
    }
}
