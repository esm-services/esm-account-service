package com.esm.account.service.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
public class SecurityConfig {
	
	@Value("${resource-server-testing.oauth2.jwt.private-key-value}")
	private String signing;
	
	@Value("${security.oauth2.resource.jwt.key-value}")
	private String verifier;

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() throws Exception {
		JwtAccessTokenConverter jwt = new JwtAccessTokenConverter();
		jwt.setSigningKey(signing);
		jwt.setVerifierKey(verifier);
		jwt.afterPropertiesSet();
		return jwt;
	}

}
