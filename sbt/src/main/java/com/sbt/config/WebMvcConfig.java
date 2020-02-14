package com.sbt.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sbt.handler.HttpInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
//	@Autowired 
//	@Qualifier(value = "httpInterceptor") 
//	private HandlerInterceptor interceptor; 
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
	    List<String> URL_PATTERNS = Arrays.asList("/user/**", "/lotto/**","/hello");
		
//		registry.addInterceptor(interceptor)
		registry.addInterceptor(new HttpInterceptor()) //������� ���ͼ���
		        .addPathPatterns(URL_PATTERNS)    // �̷������� �迭�� ����
		        .excludePathPatterns("/css/**")   // 1���� �߰��� ����
		        .excludePathPatterns("/fonts/**")
		        .excludePathPatterns("/js/**")
		        .excludePathPatterns("/login");
	}

}
