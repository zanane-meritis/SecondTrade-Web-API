package fr.secondtrade.webapi.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import fr.secondtrade.businessdao.configuration.PersistenceConfiguration;

@EnableAutoConfiguration
@ComponentScan(basePackages = { "fr.secondtrade.webapi" })
@Import({ PersistenceConfiguration.class, SecurityConfig.class })
public class ApplicationConfig {
	
}
