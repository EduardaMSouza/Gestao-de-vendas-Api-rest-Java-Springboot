package com.souzamanagement.salesmanagement;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.souzamanagement.salesmanagement.entity"})
@EnableJpaRepositories(basePackages = {"com.souzamanagement.salesmanagement.repository"})
@ComponentScan(basePackages = {"com.souzamanagement.salesmanagement.service", "com.souzamanagement.salesmanagement.controller", "com.souzamanagement.salesmanagement.exception"})
@SpringBootApplication
public class SalesManagementApplication {

	@Bean
	public static ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SalesManagementApplication.class, args);
	}

}
