package com.jun.hsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(HsiteApplication.class, args);
	}

}
