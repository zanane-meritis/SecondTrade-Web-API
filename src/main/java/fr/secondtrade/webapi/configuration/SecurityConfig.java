package fr.secondtrade.webapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fr.secondtrade.businessdao.security.AppUserDetailsService;


@EnableAutoConfiguration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AppUserDetailsService appUserDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder registry) throws Exception {
		registry.userDetailsService(appUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { // CSRF
	http.csrf().disable();
	// le mot de passe est transmis par le header Authorization: Basic xxxx
	http.httpBasic();
	// seul le rôle ADMIN peut utiliser l'application 
	http.authorizeRequests() //
		.antMatchers("/", "/**") // toutes les URL 
		.hasRole("ADMIN");
	}
}
