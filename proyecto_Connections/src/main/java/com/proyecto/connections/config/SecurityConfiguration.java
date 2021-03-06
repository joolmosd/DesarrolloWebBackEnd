
package com.proyecto.connections.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/* Providers */ 
		//first case memory users only without encryption
		/*
		auth.inMemoryAuthentication() 
			.withUser("wilson") 
			.password("{noop}123456")//{noop} plain text comment methods noPasswordEncoder/passwordEncoder
			.roles("ADMIN");
  		*/
		
		//second case database users and memory without encryption
		/*
 		auth.userDetailsService(userDetailsService); 
 		
		auth.inMemoryAuthentication()
			.withUser("wilson") 
			.password("123456") //using method noPasswordEncoder
			.roles("ADMIN");
  		*/
 
		//third case database users and memory with encryption
  		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()); 
		
		auth.inMemoryAuthentication() 
			.withUser("ADMIN")
			.password("$2a$10$mxv5x1t5/en5olhlPoFLiOmb.DIcWz8we4Xc3gS6/vHNbI1sY.Ldq") //using method passwordEncoder 
			.roles("ADMIN");
		
  
  }

	@Override protected void configure(HttpSecurity http) throws Exception {
		 http.cors()
		 	.and()
			.csrf().disable() //Cross-Site Request Forgery (falsificaci??n de petici??n en sitios cruzados) 
			.authorizeRequests()
			.antMatchers("/api/v1/postUser").hasAnyRole("ADMIN", "USER")
			.antMatchers("/api/v1/getUser/**").hasAnyRole("ADMIN", "USER")
			.antMatchers("/api/v1/putUsuario").hasAnyRole("ADMIN", "USER")
			.antMatchers("/api/v1/**").hasRole("ADMIN")
			.anyRequest().authenticated() //For any other request, you do not need specific role but still need to be authenticated. 
			.and() 
			.formLogin()//authentication method 
			.and() 
			.httpBasic() //authentication method (allow test postman POST,DELETE,PUT) 
			.and() 
			.logout();//http://localhost:8080/login?logout 
	}

	/*
	@Bean
	public PasswordEncoder noPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	*/
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
}
