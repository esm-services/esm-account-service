package com.esm.account.service.security;

import java.lang.annotation.*;

import org.springframework.security.test.context.support.WithSecurityContext;

@Inherited
@Documented
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithOAuth2AuthenticationSecurityContextFactory.class)
public @interface WithOAuth2Authentication {

	String clientId() default "myclientwith";

	String username() default "user";
}
