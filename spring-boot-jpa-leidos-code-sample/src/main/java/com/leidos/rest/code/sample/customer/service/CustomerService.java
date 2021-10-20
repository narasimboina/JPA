package com.leidos.rest.code.sample.customer.service;

import java.util.List;

import com.leidos.rest.code.sample.customer.Customer;

public interface CustomerService {

	public List<Customer> retrieveAllCustomers();

	public Customer retrieveCustomer(long id) ;

	public void deleteCustomer(long id);

	public Customer createCustomer(Customer customer);

	public Customer updateCustomer(Customer customer, long id);

}
