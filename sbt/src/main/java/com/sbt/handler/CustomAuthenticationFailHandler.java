package com.sbt.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailHandler implements AuthenticationFailureHandler {

	@Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		
		String username = request.getParameter("username");
		
		if(exception instanceof BadCredentialsException) {
            exception = new BadCredentialsException("security.exception.bad_credentials");
        }
        
        //response.sendRedirect("/login?error=" + exception.getMessage());
		response.sendRedirect("/loginErr?username="+username);
    }


}
