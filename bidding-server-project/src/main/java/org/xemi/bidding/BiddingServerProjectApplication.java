package org.xemi.bidding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.xemi.bidding")
@EnableAutoConfiguration
public class BiddingServerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiddingServerProjectApplication.class, args);
	}
}
