package com.techm.netflix.archius.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
@SpringBootApplication
@Component
@ComponentScan("com.techm.netflix.archius")
@EnableScheduling
public class StartApplication {
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
		 final Logger LOGGER = LoggerFactory.getLogger(StartApplication.class);
		  LOGGER.info("Application Started");
	}
}