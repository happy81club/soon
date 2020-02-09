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
			.and().logout() /* 로그아웃 */
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login")  /* 로그아웃 성공시 이동 URL */
			.invalidateHttpSession(true) /* 로그아웃 세션 제거 */
			.deleteCookies("JSESSIONID") /* 쿠키 제거*/
			.clearAuthentication(true)   /* 권한정보 제거*/
			.permitAll()
			.logoutSuccessUrl("/")
			.and().sessionManagement()
			.maximumSessions(1)   /* session 허용갯수 */
			.expiredUrl("/login") /* session 만료시 이동 페이지*/
			.maxSessionsPreventsLogin(false); /* true 동일한 사용자 로그인 시 안됨, false 일 경우 기존사용자 세션종료 */
			
	}
	
	/**
	 * invalidateHttpSession(true) 가 정상작동하지 않아서,
     * 로그아웃시 세션이 삭제되지 않기 때문에 로그인 후 로그아웃을 하고 
     * 다시 로그인을 하면 에러페이지로 연결이 됩니다.
     * 이를 해결하기 위해서 WebSecurityConfig 내에 httpSessionEventPublisher 메소드를 추가하여 Bean 등록해준다.
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
		/* 여기서, noop는 Spring Security에서 텍스트 그대로 비밀번호를 인식하게 해준다.
			noop을 붙이지 않으면 다른 인코딩으로 암호화를 해 주어야 한다.*/
	}
	
}