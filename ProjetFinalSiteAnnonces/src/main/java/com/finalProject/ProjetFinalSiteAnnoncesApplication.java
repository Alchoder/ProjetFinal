package com.finalProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ComponentScan
@SpringBootApplication
public class ProjetFinalSiteAnnoncesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetFinalSiteAnnoncesApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder getpce() {
		return new BCryptPasswordEncoder();
	}
}

