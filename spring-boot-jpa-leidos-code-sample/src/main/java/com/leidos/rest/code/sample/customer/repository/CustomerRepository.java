package com.leidos.rest.code.sample.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leidos.rest.code.sample.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}