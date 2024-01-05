package com.harry.publishdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PublishdemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PublishdemoApplication.class, args);

		RestTemplate template = (RestTemplate) context.getBean("restTemplate");
		System.out.println(template.getForObject("http://localhost:8080/api/content/message", String.class));
	}

}
