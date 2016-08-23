package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class AuthenticationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyTokenService tokenService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        // we don't need CSRF because our token is invulnerable
        .csrf().disable()

        .exceptionHandling().and()

        // don't create session
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

        .authorizeRequests()
        //.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

        // allow anonymous resource requests
        .antMatchers(
                HttpMethod.GET,
                "/",
                "/*.html",
                "/favicon.ico",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js"
        ).permitAll()
        .antMatchers("/auth/**").permitAll()
        .anyRequest().authenticated();
		
		http.addFilterBefore(
				new MyNewAuthenticationFilter(tokenService), UsernamePasswordAuthenticationFilter.class);
	}

}
