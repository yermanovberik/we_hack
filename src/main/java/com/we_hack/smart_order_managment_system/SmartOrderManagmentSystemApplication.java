package com.we_hack.smart_order_managment_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan(value = "com.we_hack.smart_order_managment_system")
public class SmartOrderManagmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartOrderManagmentSystemApplication.class, args);
	}

}
