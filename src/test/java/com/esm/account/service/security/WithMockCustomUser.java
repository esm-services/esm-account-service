package com.esm.account.service.security;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.security.test.context.support.WithSecurityContext;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockCustomUserSecurityContextFactory.class)
public @interface WithMockCustomUser {

	String username() default "user";

	String password() default "password";

	String name() default "Test User";

	String clientId() default "myclientwith";

	String[] scope() default { "read" };

	String[] roles() default { "USER", "ADMIN", "OPERATOR", "ACTUATOR" };
}
