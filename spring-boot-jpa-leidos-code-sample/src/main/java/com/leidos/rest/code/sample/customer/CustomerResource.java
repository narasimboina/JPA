package com.leidos.rest.code.sample.customer;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.leidos.rest.code.sample.customer.service.CustomerService;

/**
 * CustomerResource Rest API
 */
@RestController
public class CustomerResource {

	@Autowired
	private CustomerService customerService;

	/**
	 * Rest API call for
	 * @return
	 */
	@GetMapping("/customers")
	public List<Customer> retrieveAllCustomers() {
		return customerService.retrieveAllCustomers();
	}

	@GetMapping("/customers/{id}")
	public Customer retrieveCustomer(@PathVariable long id) {
		return customerService.retrieveCustomer(id);
	}

	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable long id) {
		customerService.deleteCustomer(id);
	}

	@PostMapping("/customers")
	public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customerService.createCustomer(customer);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCustomer.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer, @PathVariable long id) {

		Customer updatedCustomer = customerService.updateCustomer(customer, id);

		if (updatedCustomer == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.noContent().build();
	}
}
