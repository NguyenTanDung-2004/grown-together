package com.example.grown_together;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GrownTogetherApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrownTogetherApplication.class, args);
	}

}
