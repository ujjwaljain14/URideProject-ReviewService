package com.example.URideReviewService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class URideReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(URideReviewServiceApplication.class, args);
	}

}
