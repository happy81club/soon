package com.sbt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.sbt.handler.CustomAuthenticationFailHandler;


@Configuration 
public class SecuirtyConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
		
		http.authorizeRequests()
			.antMatchers("/user/**")
			.access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER')")
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER')")
			.antMatchers("/super/**").access("hasRole('ROLE_SUPER')")
			.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/loginProcess")
			.failureHandler(authenticationFailureHandler())
			.defaultSuccessUrl("/hello")  
			.permitAll()
			.and()
			.logout()
			.logoutUrl("/logout")
			.permitAll()
			.logoutSuccessUrl("/");
	}
	
	@Bean
	AuthenticationFailureHandler authenticationFailureHandler() {
	    return new CustomAuthenticationFailHandler();
	}

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(userDetailsService);
				
		//auth.inMemoryAuthentication().withUser("test").password("{noop}test").roles("USER");
		/* 여기서, noop는 Spring Security에서 텍스트 그대로 비밀번호를 인식하게 해준다.
			noop을 붙이지 않으면 다른 인코딩으로 암호화를 해 주어야 한다.*/
	}
	
}