package com.iocl.dhruva2api.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.iocl.dhruva2api.security.JwtTokenProvider;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

/**
 * JwtTokenFilter
 */
public class JwtTokenFilter extends GenericFilterBean {

	private JwtTokenProvider jwtTokenProvider;

	public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
		if (token != null && jwtTokenProvider.validateToken(token)) {
			Authentication auth = token != null ? jwtTokenProvider.getAuthentication(token) : null;
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		chain.doFilter(request, response);
	}

	// A (temporary) class just to represent the user credentials
	// private static class UserCredentials {
	// 	private String username, password;

	// 	public String getUsername() {
	// 		return username;
	// 	}

	// 	public void setUsername(String username) {
	// 		this.username = username;
	// 	}

	// 	public String getPassword() {
	// 		return password;
	// 	}

	// 	public void setPassword(String password) {
	// 		this.password = password;
	// 	}

	// 	// getters and setters ...
	// }
}