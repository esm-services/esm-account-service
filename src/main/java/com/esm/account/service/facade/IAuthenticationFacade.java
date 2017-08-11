package com.esm.account.service.facade;

import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {

	public Authentication getAuthentication();
}
