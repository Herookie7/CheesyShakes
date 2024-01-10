package com.herookie.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.activation.DataSource;

@SpringBootApplication
// @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

}
