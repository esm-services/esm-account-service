package com.esm.account.service.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	private final ResourceServerTokenServices tokenServices;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated();
		http.authorizeRequests()
        .antMatchers(HttpMethod.GET, "/**").access("#oauth2.hasScope('read')")
        .antMatchers(HttpMethod.POST, "/**").access("#oauth2.hasScope('write')")
        .antMatchers(HttpMethod.PATCH, "/**").access("#oauth2.hasScope('write')")
        .antMatchers(HttpMethod.PUT, "/**").access("#oauth2.hasScope('write')")
        .antMatchers(HttpMethod.DELETE, "/**").access("#oauth2.hasScope('write')")
        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll();
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenServices(tokenServices).stateless(false);
	}
}
