package com.leidos.rest.code.sample.customer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leidos.rest.code.sample.customer.Customer;
import com.leidos.rest.code.sample.customer.CustomerNotFoundException;
import com.leidos.rest.code.sample.customer.repository.CustomerRepository;
import com.leidos.rest.code.sample.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> retrieveAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer retrieveCustomer(long id) {
		Optional<Customer> customer = customerRepository.findById(id);

		if (!customer.isPresent())
			throw new CustomerNotFoundException("id-" + id);

		return customer.get();
	}

	public void deleteCustomer(long id) {
		customerRepository.deleteById(id);
	}

	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer updateCustomer(Customer customer, long id) {

		Optional<Customer> customerOptional = customerRepository.findById(id);

		if (customerOptional.isPresent()) {
			customer.setId(id);
			return customerRepository.save(customer);
		}

		return null;
	}

}
