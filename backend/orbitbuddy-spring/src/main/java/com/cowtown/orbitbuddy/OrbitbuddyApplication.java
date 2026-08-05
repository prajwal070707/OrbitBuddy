package com.cowtown.orbitbuddy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.cowtown.orbitbuddy.service.TleParserService;
import com.cowtown.orbitbuddy.service.TleService;

@SpringBootApplication
@EnableScheduling
public class OrbitbuddyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrbitbuddyApplication.class, args);
		System.out.println("application running");
	}
	
	/*
	 * @Bean CommandLineRunner run(TleService tleService, TleParserService
	 * parserService) { return args -> { String data = tleService.fetchTleData();
	 * parserService.saveTleData(data); }; }
	 * 
	 */

}
