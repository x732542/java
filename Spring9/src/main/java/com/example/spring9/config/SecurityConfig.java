package com.example.spring9.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/*
 * 驗證: Authentication
 * 授權: Authorization
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) {
		
		httpSecurity
			.authorizeHttpRequests(
					auth -> auth.requestMatchers("/login","/js/**","/css/**").permitAll()
							.requestMatchers("/admin/**").hasRole("ADMIN")
							.requestMatchers("/member/**").hasAnyRole("ADMIN","USER")
							.anyRequest().authenticated()
			).formLogin(
					form -> form.loginPage("/login")
							.usernameParameter("account")
							.passwordParameter("passwd")
							.loginProcessingUrl("/doLogin")
							.defaultSuccessUrl("/main")
							.failureUrl("/login?error")
							.permitAll()
			).logout(
					logout -> logout.logoutUrl("/logout")
							.logoutSuccessUrl("/login?logout")
							.invalidateHttpSession(true)
							.deleteCookies("JSESESSIONID")
			).exceptionHandling(e -> e.accessDeniedPage("/page403")) ;
		
		return httpSecurity.build();
		
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(
			AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}
	
	
	
}