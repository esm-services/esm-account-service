package com.esm.account.service.resource;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class AccountResource {

	@GetMapping("/message")
	@PreAuthorize("#oauth2.hasScope('read') and hasAuthority('ROLE_ACTUATOR')")
	public String message(){
		return "Welcome to OAuth2.0";
	}
}
