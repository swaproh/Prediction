package com.prediction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PredictionSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PredictionSystemApplication.class, args);
	}

}
