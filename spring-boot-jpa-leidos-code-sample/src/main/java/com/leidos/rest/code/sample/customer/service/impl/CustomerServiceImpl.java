package com.leidos.rest.code.sample.customer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leidos.rest.code.sample.customer.Customer;
import com.leidos.rest.code.sample.customer.CustomerNotFoundException;
import com.leidos.rest.code.sample.customer.repository.CustomerRepository;
import com.leidos.rest.code.sample.customer.service.CustomerService;

/**
 * CustomerServiceImpl Class for all Customer related operations
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * retrieveAllCustomer Data
	 * @return
	 */
	public List<Customer> retrieveAllCustomers() {
		return customerRepository.findAll();
	}

	/**
	 * retrieveCustomer Data
	 * @param id
	 * @return
	 */
	public Customer retrieveCustomer(long id) {
		Optional<Customer> customer = customerRepository.findById(id);

		if (!customer.isPresent())
			throw new CustomerNotFoundException("id-" + id);

		return customer.get();
	}

	/**
	 * Delete Customer Record for given Id
	 * @param id
	 */
	public void deleteCustomer(long id) {
		customerRepository.deleteById(id);
	}

	/**
	 * create Customer entry
	 * @param customer
	 * @return
	 */
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	/**
	 * Update Customer Data
	 * @param customer
	 * @param id
	 * @return
	 */
	public Customer updateCustomer(Customer customer, long id) {

		Optional<Customer> customerOptional = customerRepository.findById(id);

		if (customerOptional.isPresent()) {
			customer.setId(id);
			return customerRepository.save(customer);
		}

		return null;
	}

}
