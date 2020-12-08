package com.example.cloudnativejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SpringBootApplication
public class CloudNativeJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudNativeJavaApplication.class, args);
	}

}
