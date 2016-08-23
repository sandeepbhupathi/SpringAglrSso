package com.example;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class MyTokenService {

	public Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("token");
		Set<UserAuthority> roles = new HashSet<>();
	
		if(token!=null && !token.equals("")){
			UserAuthority e = new UserAuthority("ADMIN");
			roles.add(e);
			User user = new User();
			user.setId(10L);
			user.setUsername("SXB8019");
			user.setRoles(roles);
			return new UserAuthentication(user);
		}
		return null;
	}

}
