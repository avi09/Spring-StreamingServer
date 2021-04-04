package com.example.BasicWeb;

import com.example.BasicWeb.storage.StorageProperties;
import com.example.BasicWeb.storage.StorageService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class BasicWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicWebApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		System.out.println("Starting");
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};

	}
}
