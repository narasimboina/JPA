package com.leidos.rest.code.sample.customer;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerResourceTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getCustomerById() throws JSONException {

		String customer = this.restTemplate.getForObject("/customers/100", String.class);
		JSONAssert.assertEquals(
				"{\"id\":100,\"firstName\":\"Bayana\",\"lastName\":\"nara@gmail.com\",\"phoneNumber\":\"5106652345\",\"email\":\"Narsim\"}",
				customer, false);
	}

	@Test
	public void getAllCustomers() throws JSONException {
		String customers = this.restTemplate.getForObject("/customers", String.class);

		JSONAssert.assertEquals(
				"[{\"id\":100,\"firstName\":\"Bayana\",\"lastName\":\"nara@gmail.com\",\"phoneNumber\":\"5106652345\",\"email\":\"Narsim\"},{\"id\":101,\"firstName\":\"Chee\",\"lastName\":\"guan@gmail.com\",\"phoneNumber\":\"5673456789\",\"email\":\"Guan\"}]",
				customers, false);
	}
}