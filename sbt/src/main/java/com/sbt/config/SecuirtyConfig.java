package com.sbt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;

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
			.and().logout() /* �α׾ƿ� */
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login")  /* �α׾ƿ� ������ �̵� URL */
			.invalidateHttpSession(true) /* �α׾ƿ� ���� ���� */
			.deleteCookies("JSESSIONID") /* ��Ű ����*/
			.clearAuthentication(true)   /* �������� ����*/
			.permitAll()
			.logoutSuccessUrl("/")
			.and().sessionManagement()
			.maximumSessions(1)   /* session ��밹�� */
			.expiredUrl("/login") /* session ����� �̵� ������*/
			.maxSessionsPreventsLogin(false); /* true ������ ����� �α��� �� �ȵ�, false �� ��� ��������� �������� */
			
	}
	
	/**
	 * invalidateHttpSession(true) �� �����۵����� �ʾƼ�,
     * �α׾ƿ��� ������ �������� �ʱ� ������ �α��� �� �α׾ƿ��� �ϰ� 
     * �ٽ� �α����� �ϸ� ������������ ������ �˴ϴ�.
     * �̸� �ذ��ϱ� ���ؼ� WebSecurityConfig ���� httpSessionEventPublisher �޼ҵ带 �߰��Ͽ� Bean ������ش�.
	 * @return
	 */
	@Bean
	public ServletListenerRegistrationBean<HttpSessionEventPublisher> HttpSessionEventPublisher(){
		return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
	}
	
	@Bean
	AuthenticationFailureHandler authenticationFailureHandler() {
	    return new CustomAuthenticationFailHandler();
	}

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(userDetailsService);
				
		//auth.inMemoryAuthentication().withUser("test").password("{noop}test").roles("USER");
		/* ���⼭, noop�� Spring Security���� �ؽ�Ʈ �״�� ��й�ȣ�� �ν��ϰ� ���ش�.
			noop�� ������ ������ �ٸ� ���ڵ����� ��ȣȭ�� �� �־�� �Ѵ�.*/
	}
	
}