package com.esm.account.service.security;

import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableAuthorizationServer
class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private JwtAccessTokenConverter accessTokenConverter;

	private AuthenticationManager authenticationManager;

	@Override
	public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager).accessTokenConverter(accessTokenConverter);
	}

	@Override
	public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("myclientwith").authorizedGrantTypes("password").authorities("myauthorities")
				.resourceIds("myresource").scopes("myscope")

				.and().withClient("myclientwithout").authorizedGrantTypes("password").authorities("myauthorities")
				.resourceIds("myresource").scopes(UUID.randomUUID().toString());
	}
}
