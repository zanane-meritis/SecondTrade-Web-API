package fr.secondtrade.webapi.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import fr.secondtrade.businessdao.business.IBusiness;
import fr.secondtrade.businessdao.configuration.PersistenceConfiguration;
import fr.secondtrade.webapi.configuration.ApplicationConfig;

public class Boot {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfig.class,args); 
	}

}
