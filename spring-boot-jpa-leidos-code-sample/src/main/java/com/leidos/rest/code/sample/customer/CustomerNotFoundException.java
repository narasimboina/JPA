package com.leidos.rest.code.sample.customer;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException(String exception) {
		super(exception);
	}

}