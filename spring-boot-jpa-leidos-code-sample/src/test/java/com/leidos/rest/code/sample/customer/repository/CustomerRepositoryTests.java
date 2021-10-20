package com.leidos.rest.code.sample.customer.repository;

import com.leidos.rest.code.sample.customer.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCustomerByIdExists() {
        Customer customer = new Customer("Nara", "John", "5101234567", "howtodoinjava@gmail.com");
        customerRepository.save(customer);
        assertNotNull(customerRepository.findById(1L));
    }

    @Test
    public void tesgetAllCustomer() {
        Customer customerOne = new Customer("Nara", "John", "5101234567", "howtodoinjava@gmail.com");
        Customer customerTwo = new Customer("John", "Duke", "5101234569", "howtodoinsql@gmail.com");
        assertNotNull(customerRepository.findAll());
    }
}
