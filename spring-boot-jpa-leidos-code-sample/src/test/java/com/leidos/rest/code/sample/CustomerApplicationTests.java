package com.leidos.rest.code.sample;

import com.leidos.rest.code.sample.customer.Customer;
import com.leidos.rest.code.sample.customer.repository.CustomerRepository;
import com.leidos.rest.code.sample.customer.service.CustomerService;
import com.leidos.rest.code.sample.customer.service.impl.CustomerServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerApplicationTests {

    @InjectMocks
    @Autowired
    CustomerServiceImpl customerService;

    @Mock
    CustomerRepository customerRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllCustomerTest() {
        List<Customer> list = new ArrayList<Customer>();
        Customer customerOne = new Customer("Nara", "John", "5101234567", "howtodoinjava@gmail.com");
        Customer customerTwo = new Customer("John", "Duke", "5101234569", "howtodoinsql@gmail.com");
        Customer customerThree = new Customer("Jade", "Dave", "5101234566", "howtodoinspring@gmail.com");

        list.add(customerOne);
        list.add(customerTwo);
        list.add(customerThree);

        when(customerRepository.findAll()).thenReturn(list);
        //test
        List<Customer> customerList = customerService.retrieveAllCustomers();
        assertEquals(3, customerList.size());
    }

    @Test
    public void getCustomerTest() {
        Customer customerOne = new Customer("Nara", "John", "5101234567", "howtodoinjava@gmail.com");
        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customerOne));
        //test
        Customer customer = customerService.retrieveCustomer(1L);
        assertNotNull(customer);
        assertEquals(customerOne.getFirstName(), customer.getFirstName());
    }


}
