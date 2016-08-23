package com.example;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class MyNewAuthenticationFilter extends GenericFilterBean {

	private MyTokenService tokenSerive;
	public MyNewAuthenticationFilter(MyTokenService tokenSerive) {
		this.tokenSerive = tokenSerive;
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		SecurityContextHolder.getContext()
				.setAuthentication(tokenSerive.getAuthentication((HttpServletRequest) request));

		chain.doFilter(request, response);

	}

}
