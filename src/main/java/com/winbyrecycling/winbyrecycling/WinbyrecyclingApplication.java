package com.winbyrecycling.winbyrecycling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(/* exclude = { SecurityAutoConfiguration.class } */)
public class WinbyrecyclingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WinbyrecyclingApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
