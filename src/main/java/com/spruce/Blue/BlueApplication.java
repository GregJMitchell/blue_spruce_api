package com.spruce.Blue;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.spruce")
@EntityScan("com.spruce")
@EnableJpaRepositories("com.spruce")
@Configuration
public class BlueApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BlueApplication.class, args);
	}

	public void run(String... args) throws Exception {

	}

}
