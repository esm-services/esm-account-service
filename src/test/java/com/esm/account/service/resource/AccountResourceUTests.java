package com.esm.account.service.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.esm.account.service.security.WithMockCustomUser;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountResource.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class AccountResourceUTests {

	@Autowired
	private MockMvc mvc;

	@Test
	@WithMockCustomUser(username = "user")
	public void testHelloUserWithRole() throws Exception {
		mvc.perform(get("/message")).andExpect(status().isOk()).andExpect(content().string("Welcome to OAuth2.0"));
	}
}
