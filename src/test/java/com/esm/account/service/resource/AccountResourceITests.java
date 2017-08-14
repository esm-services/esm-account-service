package com.esm.account.service.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import lombok.Getter;
import lombok.Setter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.test.OAuth2ContextConfiguration;
import org.springframework.security.oauth2.client.test.OAuth2ContextSetup;
import org.springframework.security.oauth2.client.test.RestTemplateHolder;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.esm.account.service.ESMAccountServiceApplication;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = ESMAccountServiceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class AccountResourceITests implements RestTemplateHolder {

	@Value("http://localhost:${local.server.port}")
	protected String host;

	@Getter
	@Setter
	private RestOperations restTemplate = new RestTemplate();

	@Rule
	public OAuth2ContextSetup context = OAuth2ContextSetup.standard(this);

	@Test
	@OAuth2ContextConfiguration(UserDetails.class)
	public void testHelloUser() {
		ResponseEntity<String> entity = restTemplate.getForEntity(host + "/message", String.class);
		assertTrue(entity.toString(), entity.getStatusCode().is2xxSuccessful());
		assertEquals("Welcome to OAuth2.0", entity.getBody());
	}
}

class UserDetails extends ResourceOwnerPasswordResourceDetails {
	public UserDetails(final Object obj) {
		AccountResourceITests it = (AccountResourceITests) obj;
		setAccessTokenUri(it.host + "/oauth/token");
		setClientId("myclientwith");
		setUsername("user");
		setPassword("password");
	}
}
