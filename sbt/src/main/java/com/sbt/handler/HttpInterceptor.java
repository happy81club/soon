package com.sbt.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sbt.web.dto.User;

@Component
public class HttpInterceptor extends HandlerInterceptorAdapter {
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("preHandle................................");
		
		HttpSession session = request.getSession();
        User loginVO = (User) session.getAttribute("loginVO");
 
		/*
		 * if(ObjectUtils.isEmpty(loginVO)){ response.sendRedirect("/login"); return
		 * false; }else{ session.setMaxInactiveInterval(30*60); return true; }
		 */
        
        return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		logger.info("postHandle................................");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("afterCompletion................................");
	}
	

}
