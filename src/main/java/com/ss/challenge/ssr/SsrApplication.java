package com.ss.challenge.ssr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SsrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsrApplication.class, args);
	}

}
