package com.codeWithRaman.implementation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurity {

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user1 = User.withUsername("user").password(passwordEncoder().encode("password")).roles("USER")
				.build();
		UserDetails user2 = User.withUsername("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user1, user2);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/user/**").hasAnyRole("USER")
						.requestMatchers("/admin/**").hasAnyRole("ADMIN").anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults());

		return http.build();
	}

}
