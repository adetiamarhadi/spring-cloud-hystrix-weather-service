package com.github.adetiamarhadi.springcloudhystrixweatherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SpringCloudHystrixWeatherServiceApplication {

	private String[] weathers = new String[] {"sunny", "cloudy", "rainy", "windy"};

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystrixWeatherServiceApplication.class, args);
	}

	@GetMapping(path = "/weather")
	public String getWeather() {
		int rand = ThreadLocalRandom.current().nextInt(0, 4);
		return weathers[rand];
	}

}
