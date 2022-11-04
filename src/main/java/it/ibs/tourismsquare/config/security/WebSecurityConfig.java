package it.ibs.tourismsquare.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	final String URL="http://localhost:4200";//Development
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		//.cors().and().csrf().disable()
		http
		.csrf(
                crf -> crf.disable()
        )
		.authorizeHttpRequests((requests) -> requests
				.antMatchers("/", "/api/user/**").permitAll()
				.anyRequest().authenticated()
			)
		.formLogin((form) -> form
				.loginPage(URL+"/login")
				.permitAll()
			)
		.logout((logout) -> logout.logoutUrl(URL+"/").permitAll());

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}