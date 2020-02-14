package com.sbt.handler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class HttpInterceptor extends HandlerInterceptorAdapter implements SessionNames{
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("preHandle................................");
		
		HttpSession session = request.getSession();
        if(session.getAttribute(LOGIN) != null) {
        	session.removeAttribute(LOGIN);
        }
        
        if(session.getAttribute(LOGIN) == null) {
        	String uri = request.getRequestURI();
        	String query = request.getQueryString();
        	if(!StringUtils.isEmpty(query)) {
        		uri += "?" + query;
        		session.setAttribute(ATTEMPTED, uri);
        		response.sendRedirect("/login");
        	}
        }
        
        return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		logger.info("postHandle................................");
		
		HttpSession session = request.getSession();
		
		Object user = modelAndView.getModelMap().get("loginVO");
		
		if(user != null) {
			session.setAttribute(LOGIN, user);
			
			logger.info("Cookie setting ................................");
			Cookie loginCookie = new Cookie(LOGIN_COOKIE, session.getId());
			loginCookie.setPath("/"); // naver.com/도메인별로 생김.
			loginCookie.setMaxAge(7 * 24 * 60 * 60);
			
			response.addCookie(loginCookie);
		}
		
		String attempted = (String)session.getAttribute(ATTEMPTED);
		if(!StringUtils.isEmpty(attempted)) {
			response.sendRedirect(attempted);
			session.removeAttribute(ATTEMPTED);
		}
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("afterCompletion................................");
	}
	

}
