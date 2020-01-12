package com.sbt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration 
public class SecuirtyConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("test").password("{noop}test").roles("USER");
		/* ���⼭, noop�� Spring Security���� �ؽ�Ʈ �״�� ��й�ȣ�� �ν��ϰ� ���ش�.
			noop�� ������ ������ �ٸ� ���ڵ����� ��ȣȭ�� �� �־�� �Ѵ�.*/
	}
	
}