package com.mikeramey.divedb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class DiveDbApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DiveDbApplication.class, args);
	}
}
