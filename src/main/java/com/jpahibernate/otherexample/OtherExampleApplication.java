package com.jpahibernate.otherexample;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.jpahibernate.otherexample.repository")
@SpringBootApplication
public class OtherExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtherExampleApplication.class, args);
	}
}