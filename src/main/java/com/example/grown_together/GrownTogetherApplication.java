package com.example.grown_together;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.example.grown_together.entity.User;
import com.example.grown_together.service.UserService;

@SpringBootApplication
@EnableCaching
public class GrownTogetherApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(GrownTogetherApplication.class, args);

		// Get the Spring-managed bean
		UserService userService = context.getBean(UserService.class);

		Long start = System.currentTimeMillis();
		User user = userService.getUserProfile("92617338-04cb-4438-aee3-dd5598cbee9a");
		Long end = System.currentTimeMillis();

		System.out.println(user);
		System.out.println("Execution time: " + (end - start));

		// evict cache
		userService.upgradeToPremium("92617338-04cb-4438-aee3-dd5598cbee9a");

		Long start1 = System.currentTimeMillis();
		User user1 = userService.getUserProfile("92617338-04cb-4438-aee3-dd5598cbee9a");
		Long end1 = System.currentTimeMillis();

		System.out.println(user1);
		System.out.println("Execution time1: " + (end1 - start1));
	}
}