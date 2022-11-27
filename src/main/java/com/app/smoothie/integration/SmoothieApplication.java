package com.app.smoothie.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.app.smoothie")
@EnableJpaRepositories("com.app.smoothie.adapter.secondary.repository")
@EntityScan("com.app.smoothie.adapter.secondary.repository")
public class SmoothieApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmoothieApplication.class, args);
	}

}
