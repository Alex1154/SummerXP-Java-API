package com.products.api.productsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductsApiApplication {

  @LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(ProductsApiApplication.class, args);
	}

}
