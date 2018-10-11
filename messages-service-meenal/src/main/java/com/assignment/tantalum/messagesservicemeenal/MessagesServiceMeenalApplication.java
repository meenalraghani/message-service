package com.assignment.tantalum.messagesservicemeenal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({ "com.assignment.tantalum.controller", "com.assignment.tantalum.service"})
public class MessagesServiceMeenalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagesServiceMeenalApplication.class, args);
	}
}
