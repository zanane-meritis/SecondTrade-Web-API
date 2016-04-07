package fr.secondtrade.webapi.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.secondtrade.webapi.configuration.ApplicationConfig;

@SpringBootApplication
public class Boot {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfig.class,args); 
	}

}
