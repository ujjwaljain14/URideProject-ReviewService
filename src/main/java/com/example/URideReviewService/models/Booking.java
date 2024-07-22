package com.example.URideReviewService.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseModel{

        @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
        private Review review;

        @Enumerated(value = EnumType.STRING)
        private BookingStatus bookingStatus;

        @Temporal(TemporalType.TIMESTAMP)
        private Date startTime;

        @Temporal(TemporalType.TIMESTAMP)
        private Date endTime;

        private  Long totalDistance;

        @ManyToOne
        private Driver driver;

        @ManyToOne
        private Passenger passenger;

}
